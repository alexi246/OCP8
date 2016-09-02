package chapter_4;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.*;

/**
 * Created by Alexi on 2016-06-10.
 * This class shows many common functional interfaces as part of the API, which are useful for functional programming
 */

public class FunctionalInterfaces {


    public static void main(String[] args) {

        supplier();
        consumer();
        predicate();
        function();
        operator();
        System.out.println(optional()); // Optional.empty
        System.out.println(optional(67,74,73,62)); // Optional[69.0]
    }

    private static void supplier() {

        // the Supplier interface takes no parameters and returns a generic type
        // @FunctionalInterface public Interface Supplier<T>
        // T get();

        Supplier<LocalDate> localDateSupplier = LocalDate::now;
        System.out.println(localDateSupplier.get());
    }

    private static void consumer() {

        // The Consumer interface takes a generic parameter and returns void
        // @FunctionalInterface public Interface Consumer<T>
        // void accept(T t);

        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("Hello");

        Map<Integer, String> map = new HashMap<>();

        // The BiConsumer interface takes generic two parameters and returns void
        // @FunctionalInterface public Interface BiConsumer<T, U>
        // void accept(T t, U u);

        BiConsumer<Integer, String> mapConsumer = map::put;
        mapConsumer.accept(1, "Penguin");
        System.out.println(map); // {1=Penguin}
    }

    private static void predicate() {

        // The Predicate interface receives a generic type and returns a boolean
        // @FunctionalInterface public Interface Predicate<T>
        // boolean test(T t);

        Predicate<String> stringPredicate = String::isEmpty;
        System.out.println(stringPredicate.test(" ")); // false :-P

        // The BiPredicate interface receives two generic types and returns a boolean
        // @FunctionalInterface public Interface BiPredicate<T t, U u);
        // boolean test(T t, U u);

        BiPredicate<String, String> stringStringBiPredicate = String::startsWith;
        System.out.println(stringStringBiPredicate.test("Menagerie", "Men")); // true
    }

    private static void function() {

        // The Function interface has two generic parameters, one of which is the method parameter for its method, the other which is returned
        // @FunctionalInterface Interface Function<T, R>
        // R apply(T t);

        Function<String, Integer> stringIntegerFunction = String::length;
        System.out.println(stringIntegerFunction.apply("Sally")); // 5

        // The BiFunction interface accepts two generic arguments and returns another
        // @FunctionalInterface public Interface BiFunction<T, U, R>
        // R apply(T t, U u);

        BiFunction<String, String, String> stringStringStringBiFunction = String::concat;
        System.out.println(stringStringStringBiFunction.apply("Penguins", " are awesome!")); // Penguins are awesome!
    }

    private static void operator() {

        // The UnaryOperator interface is a special kind of Function interface, it requires all parameters to be identical.
        // It produces a result of the same type as its operand, e.g. incrementing a value is a unary operation
        // @FunctionalInterface public Interface UnaryOperator<T> extends Function<T, T>
        // T apply(T t);

        UnaryOperator<Integer> stringUnaryOperator = Integer::bitCount;
        System.out.println(stringUnaryOperator.apply(10)); // 1010, therefore dispays 2

        // The BinaryOperator interface is identical to the UnaryOperator interface except that it works with two values/parameters
        // Adding two numbers is an example of a binary operation
        // @FunctionalInterface public Interface BinaryOperator<T> extends BiFunction<T, T, T>
        // T apply(T t1, T t2);

        BinaryOperator<Boolean> stringBinaryOperator = Boolean::equals;
        System.out.println(stringBinaryOperator.apply(false, false)); // true
    }

    private static Optional<Double> optional(int... average) {

        // An Optional object represents a container which may or may not contain a null value. If a value is present, isPresent() will return true and get() will return the value

        if (average.length == 0) return Optional.empty();
        int sum = 0;
        for (int score : average) sum += score;
        return Optional.of((double) sum / average.length);
    }
}
