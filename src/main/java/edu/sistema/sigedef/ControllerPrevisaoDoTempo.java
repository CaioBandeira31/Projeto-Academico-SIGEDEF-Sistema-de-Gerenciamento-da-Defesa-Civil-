package edu.sistema.sigedef;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.JsonNode;

@Controller 
public class ControllerPrevisaoDoTempo {

    @GetMapping("Previsao")
    public String previsaoTempo(Model model){

        // Acessa o arquivo JSON na pasta Resources e Salva ele como um arquivo de LEITURA
        InputStream infoJson = getClass().getClassLoader().getResourceAsStream("previsao.json");

        // Estamos apenas instanciando uma viaravel do tipo ObjectMapper
        ObjectMapper lendoValor = new ObjectMapper();

        // estamos usando um metodo do ObjectMapper para ler os dados da variavel arquivo e salvando na variavel previsao do tipo JsonNode (formato JSON)
        JsonNode previsao = lendoValor.readTree(infoJson);

        JsonNode listaPrevisao = previsao.get("previsao");

        List<DiaPrevisao> dias = new ArrayList<>();

        for(int i = 0; i < listaPrevisao.size(); i++){

        JsonNode previsaoSolo = listaPrevisao.get(i);
        
        String data = previsaoSolo.get("dia").asString();
        int max = previsaoSolo.get("max").asInt();
        int min = previsaoSolo.get("min").asInt();
        String condicao = previsaoSolo.get("condicao").asString();
        
        DiaPrevisao dia = new DiaPrevisao(data, max, min, condicao);

        dias.add(dia);

        System.out.println(data);
        System.out.println(max+" / "+min);
        System.out.println(condicao);
        System.out.println();
        

        }

        model.addAttribute("dias",dias);

        System.out.println("DIAS NO MODEL: " + dias);
        System.out.println("QUANTIDADE: " + dias.size());
        System.out.println("Quantidade de dias: " + dias.size());

        return"desenvolvimento/pagina-previsao-do-tempo";
    }
}
