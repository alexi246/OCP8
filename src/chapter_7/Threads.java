package chapter_7;

import java.util.stream.IntStream;

/**
 * Created by alexi on 2016/06/27.
 */
public class Threads {

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                System.out.println(Math.atan(i));
            }
        }).start();

        new Average().start();
        new Thread(new Worker(1)).start();
        new Thread(new Worker(2)).start();
    }
}

class Average extends Thread {

    @Override
    public void run() {

        IntStream numbers = IntStream.of(0,1,2,3,4,5,6,7,8,9);
        System.out.println(numbers.summaryStatistics().getAverage());
    }
}

class Worker implements Runnable {

    private int id;

    public Worker(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id + " woken up.");
    }
}
