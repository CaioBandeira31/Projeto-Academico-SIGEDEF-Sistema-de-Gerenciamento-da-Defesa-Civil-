package edu.sistema.sigedef.sms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

// Classe para configuração do serviço, nesse caso é para criar a base inicial da requisição HTTP, sendo sempre o começo da url para chamar algo da API.
// Sobre a Classe RestClient, ACHO que serve como uma (classe) específica do Spring boot para criação de url de requisição HTTP para alguma API. 
@Configuration 
public class SmsBaratoConfiguration {

  @Bean 
  public RestClient SmsBaratoRestClient() {
    return RestClient.builder()
            .baseUrl("https://sistema81.smsbarato.com.br")
            .build();
  }
  
  
}
