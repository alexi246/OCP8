package chapter_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexi on 2016-06-07.
 */

/*
Lists are contiguous arrays in memory; elements can be accessed by indexes; duplicates are permitted
 */

public class Lists {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(); // ArrayLists are fast to remove and insert elements at the end of the list; very slow in the beginning and middle
        // They are very fast in locating a random element since elements are known by index

        for (int i = 1; i < 1e4; ++i)
            list.add(i);


        list.stream().forEach((i) -> System.out.print(i + " "));


        System.out.println();
        System.out.println("---------------");

        List<Integer> list1 = new LinkedList<>(); // LinkedLists are very fast to insert elements at the beginning and the middle of the list; slow at the end
        // They are also slow in locating specific elements since the element has to be searched for fom the beginning of the list

        for (int i = 1; i < 1e4; ++i)
            list1.add(i);

        list1.stream().forEach((i) -> System.out.print(i + " "));

    }
}
