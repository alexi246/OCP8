package chapter_7;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by alexi on 2016/07/11.
 */
public class BlockingQueues {

    public static void main(String[] args) {
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();

        blockingDeque.offer(91);
        try {
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);
        }catch (InterruptedException in) {
            in.printStackTrace();
        }

        System.out.println(blockingDeque.poll());

        try {
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
        }catch (InterruptedException in) {
            in.printStackTrace();
        }
    }
}
