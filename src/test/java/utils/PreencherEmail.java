package utils;

import java.util.Random;

public class PreencherEmail {

    private static final String[] NOMES = {
            "tiago", "maria", "joao", "jose", "ana", "paulo", "lucas", "fernanda",
            "carla", "roberto", "eduardo", "aline", "camila", "ricardo", "juliana"
    };

    private static final String[] SOBRENOMES = {
            "silva", "souza", "alves", "pereira", "santos", "oliveira", "rodrigues",
            "ferreira", "gomes", "barbosa", "castro", "teixeira", "melo", "dias"
    };

    private static final String[] SEPARADORES = {".", "_", "-"}; // pode ser ponto, underline ou hífen

    private static final String[] DOMINIOS = {
            "gmail.com", "hotmail.com", "outlook.com", "yahoo.com", "teste.com"
    };

    public static String gerarEmail() {
        Random random = new Random();

        // Nome e sobrenome
        String nome = NOMES[random.nextInt(NOMES.length)];
        String sobrenome = SOBRENOMES[random.nextInt(SOBRENOMES.length)];

        // Separador aleatório
        String separador = SEPARADORES[random.nextInt(SEPARADORES.length)];

        // Monta parte do usuário
        String usuario = nome + separador + sobrenome;

        // Pode adicionar números opcionais
        if (random.nextBoolean()) {
            usuario += random.nextInt(100); // de 0 até 99
        }

        // Escolhe domínio
        String dominio = DOMINIOS[random.nextInt(DOMINIOS.length)];

        return usuario.toLowerCase() + "@" + dominio;
    }
}
