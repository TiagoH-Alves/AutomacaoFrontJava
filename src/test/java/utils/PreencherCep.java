package utils;

import java.util.Random;

public class PreencherCep {

    // Prefixos baseados em faixas reais de grandes cidades brasileiras
    private static final String[] PREFIXOS_VALIDOS = {
            "01000", // São Paulo
            "20000", // Rio de Janeiro
            "30000", // Belo Horizonte
            "40000", // Salvador
            "60000", // Fortaleza
            "70000", // Brasília
            "80000", // Curitiba
            "90000"  // Porto Alegre
    };

    public static String gerarCep() {
        Random random = new Random();

        // Escolhe um prefixo de cidade conhecida
        String prefixo = PREFIXOS_VALIDOS[random.nextInt(PREFIXOS_VALIDOS.length)];

        // Últimos 3 dígitos (de 000 até 999)
        int sufixo = random.nextInt(1000);

        // Monta no formato XXXXX-XXX
        return String.format("%s-%03d", prefixo, sufixo);
    }
}
