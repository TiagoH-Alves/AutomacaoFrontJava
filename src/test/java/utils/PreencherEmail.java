package utils;

import java.util.Random;

public class PreencherEmail {

    private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITOS = "0123456789";
    private static final String[] DOMINIOS = {
            "gmail.com", "hotmail.com", "outlook.com", "yahoo.com", "teste.com"
    };

    public static String gerarEmail() {
        Random random = new Random();

        // Parte inicial (nome do usuário)
        StringBuilder usuario = new StringBuilder();

        // Letras aleatórias
        int tamanho = 5 + random.nextInt(6); // de 5 a 10 caracteres
        for (int i = 0; i < tamanho; i++) {
            usuario.append(ALFABETO.charAt(random.nextInt(ALFABETO.length())));
        }

        // Números aleatórios opcionais
        int qtdNumeros = random.nextInt(4); // até 3 dígitos no final
        for (int i = 0; i < qtdNumeros; i++) {
            usuario.append(DIGITOS.charAt(random.nextInt(DIGITOS.length())));
        }

        // Escolher domínio
        String dominio = DOMINIOS[random.nextInt(DOMINIOS.length)];

        return usuario.toString() + "@" + dominio;
    }
}
