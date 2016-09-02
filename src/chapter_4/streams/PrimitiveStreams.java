package chapter_4.streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Created by alexi on 2016/06/15.
 */
public class PrimitiveStreams {

    public static void main(String[] args) {
        DoubleStream doubleStream = DoubleStream.iterate(.5, d -> d / 2);
        doubleStream.limit(5).forEach(System.out::println); // 0.5 0.25 0.125 0.0625 0.03125

        IntStream intStream = IntStream.range(1, 6); // excluding the final parameter
        intStream.forEach((s) -> System.out.print(s + " ")); // 1 2 3 4 5
        System.out.println();
        IntStream intStream1 = IntStream.rangeClosed(1, 5); // now the second parameter is inclusive
        intStream1.forEach((s) -> System.out.print(s + " ")); // 1 2 3 4 5
        System.out.println();

        DoubleStream marks = DoubleStream.of(42, 67, 89, 45);
        OptionalDouble average = marks.average();
        average.ifPresent(System.out::println);

        IntStream range = IntStream.rangeClosed(1, 10);
        IntSummaryStatistics intSummaryStatistics = range.summaryStatistics();
        System.out.println(intSummaryStatistics.getMax() - intSummaryStatistics.getMin());

        BooleanSupplier booleanSupplier = () -> Math.random() > 0.5;
        System.out.println(booleanSupplier.getAsBoolean());

        double d = 1.0;
        DoubleToIntFunction doubleToIntFunction = (x) -> 1;
        System.out.println(doubleToIntFunction.applyAsInt(d)); // 1
    }
}
