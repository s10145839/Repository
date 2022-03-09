import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormat {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        DateTimeFormatter sgDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(today.format(sgDateFormat));

        String sgDateString = "07/04/2022";
        LocalDate date = LocalDate.parse(sgDateString, sgDateFormat);
        System.out.println(date);
    }
}
