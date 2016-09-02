package chapter_7;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by alexi on 2016/07/13.
 * The Fork/Join framework is an implementation of the ExecutorService interface. It is designed to recursively break large amounts of work into smaller pieces.
 * It uses most/all of the available processing power to enhance the application.
 * It uses the work-stealing algorithm which implies that threads which are not performing any tasks can steal work from other threads.
 */
public class ForkJoin extends RecursiveAction{

    /*
    * As we know, a recursive method is one which calls itself; it is important to define a base case or the program will hang and cause a stack overflow
    */

    public static int factorial(int n) {
        if (n <= 1) return 1; // The base case
        else return n * factorial(n - 1); // The recursive call
    }

    private int start;
    private int end;
    private Double[] weights;

    public ForkJoin(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120

        Double[] weights = new Double[10];
        ForkJoinTask<?> task = new ForkJoin(weights, 0 ,weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        System.out.println();
        System.out.println("Recursive Action: ");
        System.out.println("Weights: ");
        Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue()+ " "));

        System.out.println("Recursive Task: ");

        ForkJoinTask<Double> forkJoinTask = new ForkJoinRecursiveTask(0, weights.length, weights);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Double sum = forkJoinPool.invoke(forkJoinTask);
        System.out.println("Sum: " + sum);
    }

    @Override
    protected void compute() {

        if(end-start <=3) {
            for (int i = start; i < end; ++i) {
                weights[i] = (double) new Random().nextInt(1000);
                System.out.println("Weighed: " + i);
            }
        }
        else {
            int middle = start + ((end-start) / 2);
            System.out.println("Start: " + start + " Middle: " + middle + " End: " + end);
            invokeAll(new ForkJoin(weights, start, middle), new ForkJoin(weights, middle, end));
        }
    }
}

class ForkJoinRecursiveTask extends RecursiveTask<Double> {

    private int start;
    private int end;
    private Double[] weights;

    public ForkJoinRecursiveTask(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected Double compute() {

        if(start-end <=3) {
            double sum = 0;
            for (int i = start; i < end; ++i) {
                weights[i] = (double) new Random().nextInt(1000);
                System.out.println("Weighed: " + i);
                sum += weights[i];
            }
            return sum;
        }
        else {
            int middle = start + ((end - start) / 2);
            System.out.println("Start: " + start + " Middle: " + middle + " End: " + end);
            RecursiveTask<Double> otherTask = new ForkJoinRecursiveTask(start, middle, weights);
            otherTask.fork();
            return new ForkJoinRecursiveTask(start, middle, weights).compute() + otherTask.join();
        }
    }
}
