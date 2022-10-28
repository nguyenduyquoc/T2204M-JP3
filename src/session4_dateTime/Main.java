package session4_dateTime;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args){
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        System.out.println(ld.getMonthValue());
        System.out.println(ld.getMonth());
        System.out.println(ld.getDayOfMonth());
        System.out.println(ld.getDayOfYear());
        System.out.println(ld.getDayOfWeek());
        System.out.println(ld.plusMonths(1));

        LocalDate ld2 = LocalDate.of(2022,11,29);
        LocalDate ld3 = LocalDate.parse("2022-11-25");

        int c = ld.compareTo(ld3);
        System.out.println(c);
        long kc = ChronoUnit.DAYS.between(ld, ld3);
        System.out.println(kc);

        LocalDateTime t1 = LocalDateTime.now();
        System.out.println(t1);
        System.out.println(t1.plusMonths(1));
        System.out.println(t1.plusHours(2));

        LocalDateTime t2 = LocalDateTime.of(2022,10,27,12,15);
        LocalDateTime t3 = LocalDateTime.parse("2022-10-27T14:45:38");

    }
}
