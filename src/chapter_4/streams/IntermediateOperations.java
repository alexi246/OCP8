package chapter_4.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by alexi on 2016/06/13.
 */
public class IntermediateOperations {

    public static void main(String[] args) {
        filter();
        System.out.println();
        distinct();
        System.out.println();
        limitSkip();
        System.out.println();
        map();
        System.out.println();
        flatMap();
        System.out.println();
        sorted();
        System.out.println();
        peek();
    }

    private static void filter() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream().filter((integer) -> integer % 2 != 0).forEach((i) -> System.out.print(i + " ")); // 1 3 5 7 9
    }

    private static void distinct() {
        List<String> strings = Arrays.asList("duck", "duck", "goose");
        strings.stream().distinct().forEach((s) -> System.out.print(s + " ")); // duck goose
    }

    private static void limitSkip() {
        Stream<Integer> stream = Stream.iterate(1, (n) -> n + 1);
        stream.skip(5).limit(4).forEach((s) -> System.out.print(s + " ")); //6 7 8 9
    }

    private static void map() {
        Stream<String> names = Stream.of("Mary", "Margaret", "Anastasia", "George");
        names.map(String::length).forEach((s) -> System.out.print(s + " ")); // 4 8 9 6
    }

    private static void flatMap() {
        List<String> list = Collections.emptyList();
        List<String> list1 = Collections.singletonList("Bird");
        List<String> list2 = Arrays.asList("Whale", "Snake");
        Stream<List<String>> animals = Stream.of(list, list1, list2);
        animals.flatMap(Collection::stream).forEach((s) -> System.out.print(s + " ")); // Bird Whale Snake
    }

    private static void sorted() {
        List<Integer> numbers = Arrays.asList(4, 5, 87, 51, 2, 4);
        numbers.stream().distinct().sorted().forEach((s) -> System.out.print(s + " ")); // 2 4 5 51 87
    }

    private static void peek() {
        List<String> bears = Arrays.asList("black bear", "brown bear", "grizzly");
        long count = bears.stream().filter((s) -> s.startsWith("g")).peek(System.out::println).count();
        System.out.println(count);
    }

}
