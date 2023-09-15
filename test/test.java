
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




public class test {

    public static void main(String[] args) {

        // Creating sql date
        Date sqlDate = Date.valueOf("2020-12-31");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse("2020-12-31", formatter);

        System.out.println(date);

    }
}
