package chapter_7;

import java.util.concurrent.*;

/**
 * Created by alexi on 2016/06/29.
 */
public class Synchronising {

    private int count  = 0;

    private void increment() {
        synchronized (this) {
            for(int i = 0;i<100000;++i)
                ++count;
        }
    }

    public static void main(String[] args) throws InterruptedException{

        java.util.concurrent.ExecutorService executorService = null;

        Synchronising synchronising = new Synchronising();

        try {
            executorService = Executors.newFixedThreadPool(5);
            executorService.submit(synchronising::increment);
        }finally {
            if(executorService!=null) executorService.shutdown();
        }

        executorService.awaitTermination(10, TimeUnit.SECONDS);

        if(executorService.isTerminated()) System.out.println("All threads are completed");

        System.out.println(synchronising.count);

    }
}
