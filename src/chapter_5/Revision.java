package chapter_5;

import java.time.*;

/**
 * Created by alexi on 2016-06-16.
 */
public class Revision {

    public static void main(String[] args) {

        String poolName = "Alexi";
        String poolName1 = "Alexi";
        String nameObject = new String("Alexi");
        System.out.println(poolName == poolName1); // true
        System.out.println(poolName == nameObject); // false
        System.out.println(poolName.equals(nameObject)); // true

        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
    }
}
