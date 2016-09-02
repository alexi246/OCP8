package chapter_7;

import java.text.DecimalFormat;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by alexi on 2016/06/28.
 */
public class ExecutorService {


    public static void main(String[] args) throws InterruptedException{

        java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<?> future = executorService.submit(() -> {
            AtomicInteger atomicInteger = new AtomicInteger();
            for (int i = 0; i < 1e5; ++i) {
                atomicInteger.incrementAndGet();
            }
            return atomicInteger;
        });

        executorService.shutdown();

        executorService.awaitTermination(10, TimeUnit.SECONDS);

        if(executorService.isTerminated())
            System.out.println("Threads completed their tasks");

        if(future.isDone())
            try {
                System.out.println(future.get());
            }catch (ExecutionException e) {
                System.out.println(e.getMessage());
            }
    }
}
