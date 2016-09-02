package chapter_7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexi on 2016/07/11.
 */
public class ParallelStreams {

    public int processRecord(int input) {
        try {
            Thread.sleep(10);
        }catch (InterruptedException in) {in.printStackTrace();}
        return input+1;
    }

    public void processAllData(List<Integer> data) {
        data.parallelStream().map(this::processRecord).count();
    }

    public static void main(String[] args) {

        ParallelStreams parallelStreams = new ParallelStreams();

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 4000; ++i) integerList.add(i);

        long start = System.currentTimeMillis();
        parallelStreams.processAllData(integerList);
        double time = (System.currentTimeMillis()-start)/1000.0;

        System.out.println("\nTasks completed in " + time + " seconds.");
    }
}
