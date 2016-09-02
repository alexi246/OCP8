package chapter_4.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by alexi on 2016/06/15.
 */
public class Advanced {

    public static void main(String[] args) {
        List<String> dogs = new ArrayList<>(Arrays.asList("Rex", "Charlie", "Brutus"));
        Stream<String> stream = dogs.stream();
        dogs.add("Jeremy");
        System.out.println(stream.count()); // 4

        Optional<Integer> integerOptional = Optional.of(5), integerOptional1 = Optional.of(123), integerOptional2 = Optional.empty();
        integerOptional.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);

        integerOptional1.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);

        integerOptional2.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        System.out.println(ohMy.collect(Collectors.joining(", ")));

        Stream<String> animals = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = animals.collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        Stream<String> structures = Stream.of("buildings", "cities", "countries");
        TreeMap<Integer, Set<String>> integerSetTreeMap = structures.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(integerSetTreeMap);

        //Map<Integer, Optional<Character>> integerOptionalMap = structures.collect(Collectors.groupingBy(String::length, Collectors.mapping((s) -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
        //System.out.println(integerOptionalMap);

    }

}
