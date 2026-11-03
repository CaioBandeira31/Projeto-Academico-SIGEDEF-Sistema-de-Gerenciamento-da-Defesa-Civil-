package edu.sistema.sigedef.Validacoes;

import java.security.SecureRandom;

public class GeradorMatricula {

    public String gerarMatricula(){
        SecureRandom random = new SecureRandom();
        String senha ="";
        Integer caracSenha;
        for(int i=1; i<=7; i++){
            caracSenha = random.nextInt(10);

            senha=senha+caracSenha.toString();
        }


    return senha.trim(); 
    }

}
