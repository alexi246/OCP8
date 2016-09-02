package chapter_3;

import java.util.*;

/**
 * Created by Alexi on 2016-06-08.
 */

/*
Queues usually order their elements in a first-in-first-out manner with the exception of the PriorityQueue and the Stacks which order their elements in a last-in-first-out manner
 */

public class Queues {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(); // A PriorityQueue will sort elements in either natural ordering or by a Comparator provided in the Queue's constructor

        for (int i = 1; i < 10; ++i)
            queue.add(i);

        queue.stream().forEach(integer -> System.out.print(integer + " "));

        System.out.println("-----------------");

        List<String> list = new Stack<>(); // A Stack orders its elements in a last-in-first-out manner

        list.add("Second");
        list.add("First");
        list.add("Last");
        list.add("Third");

        list.forEach(System.out::println);

        ArrayDeque<Integer> stack = new ArrayDeque<>(); /* An ArrayDeque is a double-ended queue which can be used as a queue or a Stack; the difference comes from which methods are used with the collection
                                                      -> push/poll/peak is for a Stack and offer/poll/peak is for a Queue
                                                   */

        stack.push(3); // |3|
        stack.push(5); // [5,3]
        stack.push(9); // [9,5,3]
        stack.poll();  // [5,3]
        stack.poll();  // [3]
        stack.poll();  // []
        System.out.println(stack);


        Queue<Integer> queue1 = new ArrayDeque<>();
        queue1.offer(1); // [1]
        queue1.offer(3); // [1,3]
        queue1.offer(5); // [1,3,5]
        queue1.poll();   // [3,5]
        queue1.poll();   // [5]
        queue1.poll();   // []
        System.out.println(queue1);
    }
}
