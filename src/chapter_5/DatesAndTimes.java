package chapter_5;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by alexi on 2016/06/27.
 */
public class DatesAndTimes {

    public static void main(String[] args) {

        System.out.println(ZonedDateTime.now());
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter((z) -> z.contains("Africa"))
                .sorted()
                .forEach(System.out::println);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(2012, 1, 1, 14, 0, 0, 400000000, ZoneId.of("Africa/Johannesburg"));
        System.out.println(zonedDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy, MMMM, dd, hh:mm a");
        System.out.println(LocalDateTime.now().format(dateTimeFormatter));

        timeDifference(LocalDate.now(), LocalDate.of(1992, Month.NOVEMBER, 23));
    }

    public static void timeDifference(LocalDate localDate, LocalDate localDate1) {

        Period period = Period.between(localDate1, localDate);

        System.out.printf("%s years, %s months and %s days have passed", period.getYears(), period.getMonths(), period.getDays());
    }
}
