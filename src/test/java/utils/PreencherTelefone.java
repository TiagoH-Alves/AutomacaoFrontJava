package utils;

import java.util.Random;

public class PreencherTelefone {

    private static final String[] DDDS_VALIDOS = {
            "11", // São Paulo
            "21", // Rio de Janeiro
            "31", // Belo Horizonte
            "41", // Curitiba
            "51", // Porto Alegre
            "61", // Brasília
            "71", // Salvador
            "85"  // Fortaleza
    };

    public static String gerarTelefoneCelular() {
        Random random = new Random();

        // Escolhe um DDD válido
        String ddd = DDDS_VALIDOS[random.nextInt(DDDS_VALIDOS.length)];

        // Celular no Brasil: sempre começa com 9
        int parte1 = 90000 + random.nextInt(10000); // 90000 até 99999
        int parte2 = 1000 + random.nextInt(9000);   // 1000 até 9999

        return String.format("(%s) %d-%04d", ddd, parte1, parte2);
    }
}
