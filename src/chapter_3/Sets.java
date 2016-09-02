package chapter_3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Alexi on 2016-06-08.
 */


/*
Sets are collections which do not contain any duplicates; there are three main Set types; the HashSet, the TreeSet and the LinkedHashSet
If custom objects are to be added to a set then your class must implement the equals() and hashCode() methods
 */

public class Sets {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(); // A HashSet orders its elements in any random order; no ordering is guaranteed

        set.add(23);
        set.add(1);
        set.add(50);
        set.add(5215);

        set.stream().forEach(integer -> System.out.print(integer + " "));

        System.out.println();
        System.out.println("--------------");

        Set<Integer> set1 = new TreeSet<>(); // A TreeSet's elements are always ordered in natural order; numbers go from 0-N and Strings are ordered alphanumerically

        set1.add(414);
        set1.add(2);
        set1.add(525);

        set1.stream().forEach(integer -> System.out.print(integer + " "));

        System.out.println();
        System.out.println("--------------");

        Set<Integer> set2 = new LinkedHashSet<>(); // A LinkedHashSet orders its elements in the order they were added to the collection

        set2.add(24);
        set2.add(1);
        set2.add(67);

        set2.stream().forEach(integer -> System.out.print(integer + " "));

        System.out.println();
    }
}
