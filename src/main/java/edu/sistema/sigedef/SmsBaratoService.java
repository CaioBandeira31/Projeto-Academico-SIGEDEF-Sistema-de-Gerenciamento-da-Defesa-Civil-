package edu.sistema.sigedef;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

// Criação da classe que realizará a requisição para a API para enviar o sms. Ela é "filha" do SmsSender, tendo obrigatoriamente o método envioSms, mas não somente ele, claramente alterado.
@Service("smsbarato")
public class SmsBaratoService implements  SmsSender{

  private final RestClient restClient;
  private final String apiKey;

  // Construtor para resgatar a chave da API e a base da requisição HTTP no arquivo de configuração.
  public SmsBaratoService(RestClient smsBaratoRestClient, @Value("${smsbarato.api-key}") String apiKey){
    this.restClient = smsBaratoRestClient;
    this.apiKey = apiKey;
  }

  // Método obrigatorio sobrescrito, vide anotação.
  @Override 
  public void envioSms(TelefoneSms telefoneSms){

    // Texto que será enviado com o código de confirmação
    String mensagem = "Código de confirmação: " + telefoneSms.getCodigo();
    
    /* Aqui está sendo criado um tipo de lista que associa "chaves" com uma coleção de valores
    As "chaves" seriam os textos em aspas e a coleção são os dados que queremos colocar*/

    // Vale lembrar que estas "chaves" são os nomes exatos dos campos pedidos na documentação da API para que a requisição seja feita corretamente

    // A lista MultiValueMap não é usada somente para realizar requisições em API, lembrar de generalizar o que foi dito no segungo comentário acima 
    MultiValueMap<String, String> dados = new LinkedMultiValueMap<>();
    
    // Adicionando a relação de chaves e coleção ou valores
    dados.add("chave", apiKey);
    dados.add("dest", telefoneSms.getNum_Telefone());
    dados.add("text", mensagem);

    // Aqui tudo será juntado e enviado, além de executar uma resposta
    String resposta = restClient.post() // método POST de envio, obviamente, são dados sensíveis
              .uri("/send") //Após a criação da url base na configuração esse texto será posto em seguida, podendo ser alterado, caso queira mudar o tipo de requisição para API. EX: /2fasend
              .contentType(MediaType.APPLICATION_FORM_URLENCODED) /*Informa que os dados serão enviado no estilo chave/valor, como o tipo da lista descrita acima */
              .body(dados) /*Concatena os valores da lista dados na url */
              .retrieve() /* Envia a url e espera a resposta da API */
              .body(String.class); /* Acopla a resposta da API na String resposta */

    System.out.println("Resposta da API pela requisição de enviar o sms: "+resposta);
    // A linha cima serve apenas para identificar se ocorreu algum erro no envio do SMS, caso tenha sido enviado corretamete, aparecerá uma sequência de números, caso contrário será enviado uma mensagem de erro
  }



}
