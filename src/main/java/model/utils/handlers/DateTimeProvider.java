package model.utils.handlers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeProvider {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String getNow() {
        return LocalDateTime.now().format(formatter);
    }

    public static String formatTimeStamp(Timestamp datetime) {
        LocalDateTime dateTime = datetime.toLocalDateTime();
        return dateTime.format(formatter);
    }
}
