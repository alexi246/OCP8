package chapter_2;

/**
 * Created by Alexi on 2016-06-04.
 */
public class SingletonDesign {

    private static volatile SingletonDesign singletonDesign;

    public static SingletonDesign getSingletonDesign() {
        if (singletonDesign == null) {
            synchronized (SingletonDesign.class) {
                if (singletonDesign == null) {
                    singletonDesign = new SingletonDesign();
                }
            }
        }
        return singletonDesign;
    }

    @Override
    public String toString() {
        return "Singleton class";
    }
}

class TestSingleton {

    public static void main(String[] args) {
        SingletonDesign singletonDesign = SingletonDesign.getSingletonDesign();
        System.out.println(singletonDesign);
    }
}
