package chapter_7;

import java.util.concurrent.*;

/**
 * Created by alexi on 2016/07/15.
 */
public class InterruptingThreads {

    public static void main(String[] args) {

        //thread();
        threadPool();
    }

    /*public static void thread() {

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException in) {
                System.out.println(in.getMessage());
            }
        }, "Jimmy");

        thread.start();

        //thread.interrupt();

        if(thread.isInterrupted())
            System.out.println("Thread has been interrupted");
        else
        System.out.println(thread.getName() + " is done");

    }*/

    public static void threadPool() {

        java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<?> future = executorService.submit(() -> {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException in) {
                    System.out.println(in.getMessage());
                }

                double result = 0.0;
                for(int i = 0;i<1e8;++i)
                   result += Math.atan(i);

                return result;

        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        future.cancel(true);

        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
