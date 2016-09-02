package chapter_3;

/**
 * Created by Alexi on 2016-06-09.
 */
public class Generics<T> {

    private T t;

    public Generics(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return t.toString();
    }

    public static void main(String[] args) {
        Generics<String> generics = new Generics<>("Bob");
        System.out.println(generics);
    }
}
