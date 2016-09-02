package chapter_2;

import java.util.*;

/**
 * Created by Alexi on 2016-06-04.
 */
public final class Immutable {

    private final List<String> list;
    private final String name;
    private final int number;

    public Immutable(String name, int number, List<String> list) {
        this.name = name;
        this.number = number;
        this.list = new ArrayList<>(list);
    }

    public int getSize() {
        return list.size();
    }

    public String getMember(int index) {
        return list.get(index);
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}

class TestImmutable {

    public static void main(String[] args) {
        Immutable immutable = new Immutable("Immutable class", 1, Arrays.asList("Tom", "Tim", "Mary", "Bob", "Greg"));

        for (int i = 0; i < immutable.getSize(); ++i) {
            System.out.println(immutable.getMember(i));
        }
    }
}
