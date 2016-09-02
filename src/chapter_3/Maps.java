package chapter_3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Alexi on 2016-06-08.
 */

/*
Maps provide a key-value relationship; all elements are associated with their respective keys. Keys are unique and no identical key may exist in a single Map collection, however, the values can be duplicated
If a custom object is to be added to a map then your class must implement the equals() and hashCode() methods
 */

public class Maps {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>(); // HashMaps order their keys according to the key's hashCode()

        map.put(3, "Third");
        map.put(1, "First");
        map.put(4, "Fourth");
        map.put(2, "Second");

        System.out.println("HashMap: ");
        map.entrySet().stream().forEach(integerStringEntry -> System.out.print(integerStringEntry + " "));

        System.out.println();
        System.out.println("----------");

        Map<Integer, String> map1 = new TreeMap<>(); // TreeMaps order their elements in a natural ordering; same as a Set

        map1.put(2, "Second");
        map1.put(1, "First");
        map1.put(3, "Third");
        map1.put(4, "Fourth");

        System.out.println("TreeMap: ");
        map1.entrySet().stream().forEach(integerStringEntry -> System.out.print(integerStringEntry + " "));

        System.out.println();
        System.out.println("----------");

        Map<Integer, String> map2 = new LinkedHashMap<>(); // LinkedHashMaps order their elements in the order they were added

        map2.put(4, "Fourth");
        map2.put(2, "Second");
        map2.put(1, "First");
        map2.put(3, "Third");

        System.out.println("LinkedHashMap: ");
        map2.entrySet().stream().forEach(integerStringEntry -> System.out.print(integerStringEntry + " "));

        System.out.println();

    }
}
