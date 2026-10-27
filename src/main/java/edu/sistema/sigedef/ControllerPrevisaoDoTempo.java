package edu.sistema.sigedef;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;





@Controller 
public class ControllerPrevisaoDoTempo {

    // Switch case para formatar a condição recebida de sigla para o texto correto
    private String traduzirCondicao(String codigo) {
    return switch (codigo) {
        case "ec" -> "Encoberto com Chuvas Isoladas";
        case "ci" -> "Chuvas Isoladas";
        case "c" -> "Chuva";
        case "in" -> "Instável";
        case "pp" -> "Poss. de Pancadas de Chuva";
        case "cm" -> "Chuva pela Manhã";
        case "cn" -> "Chuva a Noite";
        case "pt" -> "Pancadas de Chuva a Tarde";
        case "pm" -> "Pancadas de Chuva pela Manhã";
        case "np" -> "Nublado e Pancadas de Chuva";
        case "pc" -> "Pancadas de Chuva";
        case "pn" -> "Parcialmente Nublado";
        case "cv" -> "Chuvisco";
        case "ch" -> "Chuvoso";
        case "t" -> "Tempestade";
        case "ps" -> "Predomínio de Sol";
        case "e" -> "Encoberto";
        case "n" -> "Nublado";
        case "cl" -> "Céu Claro";
        case "nv" -> "Nevoeiro";
        case "g" -> "Geada";
        case "ne" -> "Neve";
        case "nd" -> "Não Definido";
        case "pnt" -> "Pancadas de Chuva a Noite";
        case "psc" -> "Possibilidade de Chuva";
        case "pcm" -> "Possibilidade de Chuva pela Manhã";
        case "pct" -> "Possibilidade de Chuva a Tarde";
        case "pcn" -> "Possibilidade de Chuva a Noite";
        case "npt" -> "Nublado com Pancadas a Tarde";
        case "npn" -> "Nublado com Pancadas a Noite";
        case "ncn" -> "Nublado com Poss. de Chuva a Noite";
        case "nct" -> "Nublado com Poss. de Chuva a Tarde";
        case "ncm" -> "Nubl. c/ Poss. de Chuva pela Manhã";
        case "npm" -> "Nublado com Pancadas pela Manhã";
        case "npp" -> "Nublado com Possibilidade de Chuva";
        case "vn" -> "Variação de Nebulosidade";
        case "ct" -> "Chuva a Tarde";
        case "ppn" -> "Poss. de Panc. de Chuva a Noite";
        case "ppt" -> "Poss. de Panc. de Chuva a Tarde";
        case "ppm" -> "Poss. de Panc. de Chuva pela Manhã";
        default -> "Condição desconhecida";
    };
}

    // switch case para o icone
    private String iconeCondicao(String codigo) {
    return switch (codigo) {
        // Sol
        case "ps", "cl" -> "clear_day";

        // Nebulosidade
        case "pn", "vn" -> "partly_cloudy_day";
        case "n", "e" -> "cloud";
        case "ec" -> "rainy";
        
        // Chuvas
        case "ci", "c", "cv", "ch", "cm", "cn",
             "ct", "pc", "pnt" -> "rainy";

        case "pp", "pt", "pm", "np", "npt", "npn",
             "npm" -> "rainy";

        // Possibilidade de chuva
        case "psc", "pcm", "pct", "pcn",
             "ncn", "nct", "ncm", "npp",
             "ppn", "ppt", "ppm" -> "rainy";

        // Instabilidade e tempestade
        case "in", "t" -> "thunderstorm";

        // Outros fenômenos
        case "nv" -> "foggy";
        case "g" -> "ac_unit";
        case "ne" -> "weather_snowy";

        default -> "question_mark";
    };
}

    @GetMapping("Previsao")
    public String previsaoTempo(Model model) {

        // declarando uma lista da Classe DiaPrevisao
        List<DiaPrevisao> dias = new ArrayList<>();
        
        // classe responsavel por tratar o link
        HttpClient cliente = HttpClient.newHttpClient();

        // depois de estanciars estmaos informando exatamente para o objeto de onde estamos buscando os dados(HTTP)
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create("https://servicos.cptec.inpe.br/XML/cidade/7dias/2580/previsao.xml")).GET().build();

        // Try catch para controle do codigo, para sabermos se havera algum erro 
        try {
            
            //Acima instaciamos um objeto que faz a requisição, nesse caso estamos estanciando o bjeto que vai receber a resposta 
            HttpResponse<String> resposta = cliente.send(requisicao,HttpResponse.BodyHandlers.ofString()
            );

            // Apenas mostrando oque recebemos
            // System.out.println("STATUS: " + resposta.statusCode());
            // System.out.println(resposta.body());

            // Estamos estacniando uma "fabrica" que vai ser responsavel por intepretas os dados via XML
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

            // ps: é uma medida de segurança a grosso modo estamos desativando declarações DOCTYPE para evitar ataques via XML 
            fabrica.setFeature(
                    "http://apache.org/xml/features/disallow-doctype-decl",
                    true
            );
            // -----------------------------------------------------------------------------------------------------------------

            //estamos instaciando um objeto que tera a função de guarda a estrutura que for interpretada pela "fabrica"
            Document documento = 

                // metodo que interpreta o documento
                fabrica.newDocumentBuilder().parse(

                    // Fornece a entrada ao Parser
                    new InputSource(
                        // permite ler esse texto
                        new StringReader(
                            // pega o xml recebido
                            resposta.body()
                        )
                    )
            );

            // bem silimilar ao JsonNode aqui estamos buscando dentro do "documento" todas os elemetnos com a tag "previsao"
            NodeList previsoes = documento.getElementsByTagName("previsao");

            // for para percorrer os dias com os dados
            for (int i = 0; i < previsoes.getLength(); i++) {

                // aqui instanciamos um Element que ira pegar um elemento separadamente utilizando o I como indice
                Element previsaoSolo = (Element) previsoes.item(i);

                // Separando os dados em seus respectivos lugarem (Metodos autoexplicativos)
                String dataOriginal = previsaoSolo.getElementsByTagName("dia").item(0).getTextContent();

                int max = Integer.parseInt(previsaoSolo.getElementsByTagName("maxima").item(0).getTextContent());

                int min = Integer.parseInt(previsaoSolo.getElementsByTagName("minima").item(0).getTextContent());

                String condicao = previsaoSolo.getElementsByTagName("tempo").item(0).getTextContent();

                // mudando o incone da previsao
                String icone = iconeCondicao(condicao);

                // Fazendo a formatação da condicao
                condicao = traduzirCondicao(condicao);
                
                LocalDate dataConvertida = LocalDate.parse(dataOriginal);

                DateTimeFormatter formato = DateTimeFormatter
                    .ofPattern("dd 'de' MMMM 'de' yyyy", Locale.of("pt", "BR"));

                String data = dataConvertida.format(formato);

                // salvando os dados em um Objeto Dia
                DiaPrevisao dia = new DiaPrevisao(data, max, min, condicao, icone);

                // salvando o objeto em um indice da lista Dias
                dias.add(dia);

                // enviando para visao
                model.addAttribute("dias", dias);


            }

        } catch (IOException | InterruptedException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

            // Apenas Vizualição Desconsiderar

            // System.out.println("Quantidade de dias: " + dias.size());

            // for (DiaPrevisao dia : dias) {
            //     System.out.println(dia.getDia());
            //     System.out.println(dia.getMax() + " / " + dia.getMin());
            //     System.out.println(dia.getCondicao());
            //     System.out.println();
            // }

        return "desenvolvimento/pagina-previsao-do-tempo";
    }
    
}
