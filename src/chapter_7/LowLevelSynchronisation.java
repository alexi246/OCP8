package chapter_7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * Created by alexi on 2016/07/04.
 */
public class LowLevelSynchronisation {

    private Deque<Integer> integerList = new LinkedList<>();
    private final Object lock = new Object();

    public void produce() throws InterruptedException {

        synchronized (lock) {


                for (int i = 0; i < 10; i++) {
                    integerList.add(i);
                    System.out.println(integerList.size());
                }
                lock.wait(200);

        }
    }

    public void consume() throws InterruptedException {

        synchronized (lock) {
            Thread.sleep(500);

                for (int i = 0; i < 10; i++) {
                    integerList.removeFirst();
                    System.out.println(integerList.size());
                }
                lock.notify();

        }
    }
}

class Main {
    public static void main(String[] args) {

        java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                new LowLevelSynchronisation().produce();
            } catch (InterruptedException in) {
                in.printStackTrace();
            }
        });

        executorService.submit(() -> {
           try {
               new LowLevelSynchronisation().consume();
           }catch (InterruptedException in) {
               in.printStackTrace();
           }
        });

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
