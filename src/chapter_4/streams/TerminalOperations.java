package chapter_4.streams;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by alexi on 2016/06/12.
 */
public class TerminalOperations {

    public static void main(String[] args) {
        count();
        minMax();
        findAnyFindFirst();
        match();
        forEach();
        System.out.println();
        reduce();
        collect();
    }

    public static void count() {
        List<Integer> integers = Arrays.asList(2, 5, 6, 9, 53, 8);
        System.out.println(integers.stream().count()); // 6
    }

    public static void minMax() {
        List<String> stringList = Arrays.asList("monkey", "lion", "cheetah");
        System.out.println(stringList.stream().min((s, s1) -> s.length() - s1.length())); // Optional[lion]
        System.out.println(stringList.stream().max((s, s1) -> s.length() - s1.length())); // Optional[cheetah]
    }

    public static void findAnyFindFirst() {
        List<String> strings = Arrays.asList("Jenny", "Jimmy", "Bobby");
        strings.stream().findAny().ifPresent(System.out::println); // Jenny
    }

    public static void match() {
        List<String> list = Arrays.asList("mammal", "amphibian", "23");
        System.out.println(list.stream().allMatch((s) -> Character.isLetter(s.charAt(0)))); // false
        System.out.println(list.stream().anyMatch((s) -> Character.isLetter(s.charAt(0)))); // true
        System.out.println(list.stream().noneMatch((s) -> Character.isLetter(s.charAt(0)))); // false
    }

    public static void forEach() {
        List<Integer> list = Arrays.asList(2, 5, 4, 7);
        list.forEach(System.out::print); // [2547]
    }

    public static void reduce() {
        List<String> list = Arrays.asList("t", "i", "g", "e", "r");
        List<Integer> numbers = Arrays.asList(1, 3, 5, 9);
        System.out.println(list.stream().reduce("", String::concat));
        System.out.println(numbers.stream().reduce(1, (integer, integer1) -> integer * integer1)); // 135; if we omit the identity. i.e. the 1, it returns Optional[135]
        /*
         If the identity parameter is omitted, Java returns an Optional based on the scenario; an empty stream will return an empty Optional,
         a stream with one element will return the element and if the stream has many elements then they are combined via the accumulator.
         */
    }

    public static void collect() {
        List<String> list = Arrays.asList("B", "o", "b");
        StringBuilder stringBuilder = list.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(stringBuilder); // Bob

        List<String> strings = Arrays.asList("Jim", "Parsons");
        TreeSet<String> treeSet = strings.stream().collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(treeSet); // [Jim, Parsons]
    }
}
