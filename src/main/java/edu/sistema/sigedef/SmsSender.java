package edu.sistema.sigedef;

// Criação de uma interface para que todas as classes filhas desta interface tenham obrigatoriamente que possuir o método envioSms(), tornando a troca de provedor do serviço mais fácil e possibilitando utilizar mais de um, mas com a mesma padronização. Pelo o que eu entendi.
public interface SmsSender {
    void envioSms(TelefoneSms telefoneSms);
  
}
