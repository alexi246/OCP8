package chapter_7;

import java.util.concurrent.*;

/**
 * Created by alexi on 2016/07/08.
 */
public class CyclicBarrier {

    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning pen");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

    public void performTask(java.util.concurrent.CyclicBarrier gate1, java.util.concurrent.CyclicBarrier gate2) {
        try {
            removeAnimals();
            gate1.await();
            cleanPen();
            gate2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException broken) {
            broken.printStackTrace();
        }
    }

    public static void main(String[] args) {
        java.util.concurrent.ExecutorService executorService = null;

        try {
            executorService = Executors.newFixedThreadPool(4);

            CyclicBarrier cyclicBarrier = new CyclicBarrier();
            java.util.concurrent.CyclicBarrier gate1 = new java.util.concurrent.CyclicBarrier(4);
            java.util.concurrent.CyclicBarrier gate2  = new java.util.concurrent.CyclicBarrier(4, () -> System.out.println("***Pen Cleaned***"));

            for(int i = 0;i<4;++i)
                executorService.submit(() -> cyclicBarrier.performTask(gate1, gate2));

        } finally {
            if(executorService!=null) executorService.shutdown();
        }
    }
}
