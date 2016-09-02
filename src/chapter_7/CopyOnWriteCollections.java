package chapter_7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by alexi on 2016/07/11.
 */
public class CopyOnWriteCollections {

    public static void main(String[] args) {
        List<Integer> integerList = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));

        for(Integer integer: integerList) {
            System.out.print(integer + " ");
            integerList.add(9);
        }

        System.out.println();
        System.out.println("Size: "+ integerList.size());
    }
}
