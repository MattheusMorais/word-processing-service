package utils.providers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe utilitária para manipulação e formatação de datas.
 */
public class DateTimeProvider {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Retorna a data e hora atual formatada.
     *
     * @return data e hora atual
     */
    public static String getNow() {
        return LocalDateTime.now().format(formatter);
    }

    /**
     * Formata um timestamp para string.
     *
     * @param datetime timestamp do banco
     * @return data formatada
     */
    public static String formatTimeStamp(Timestamp datetime) {
        LocalDateTime dateTime = datetime.toLocalDateTime();
        return dateTime.format(formatter);
    }
}
