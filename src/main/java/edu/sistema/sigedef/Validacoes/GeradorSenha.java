package edu.sistema.sigedef.Validacoes;

import java.security.SecureRandom;

public class GeradorSenha {

    public static String gerarSenha() {

        SecureRandom random = new SecureRandom();

        String numeros = "0123456789";
        String especiais = "!@#$%&*";

        StringBuilder senha = new StringBuilder();

        // Gera 11 números
        for (int i = 0; i < 11; i++) {
            int indice = random.nextInt(numeros.length());
            senha.append(numeros.charAt(indice));
        }

        // Adiciona 1 caractere especial
        char especial = especiais.charAt(random.nextInt(especiais.length()));
        senha.append(especial);

        // Embaralha a senha
        for (int i = senha.length() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            char temporario = senha.charAt(i);
            senha.setCharAt(i, senha.charAt(j));
            senha.setCharAt(j, temporario);
        }

        return senha.toString();
    }
}
