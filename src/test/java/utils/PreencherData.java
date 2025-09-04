package utils;

import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PreencherData {

    public static String gerarData() {
        Random random = new Random();

        // Data limite: hoje - 18 anos
        LocalDate dataMaxima = LocalDate.now().minusYears(18);

        // Vamos permitir pessoas até 100 anos atrás
        LocalDate dataMinima = dataMaxima.minusYears(82);

        // Dias entre mínima e máxima
        long diasEntre = dataMaxima.toEpochDay() - dataMinima.toEpochDay();

        // Gera um número aleatório dentro desse intervalo
        long diasAleatorios = (long) (random.nextDouble() * diasEntre);

        // Soma os dias para obter a data
        LocalDate dataNascimento = dataMinima.plusDays(diasAleatorios);

        // Formatar em dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formatter);
    }
}
