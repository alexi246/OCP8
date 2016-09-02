package chapter_2;

/**
 * Created by alexi on 2016/07/12.
 * This class will demonstrate the differences between lambdas, method references and the old anonymous way of doing things
 */
public class LambdasAndMethodReferences {

    public static void main(String[] args) {

        // This anonymous way is prior to Java 8; many lines of code are needed just to override one method
        Functional<Integer, String> integerFunctional = new Functional<Integer, String>() {
            @Override
            public String get(Integer integer) {
                return integer.toString();
            }
        };
        System.out.println(integerFunctional.get(1234).concat("56789"));

        // The new lambda way of implementing the abstract method from an interface
        Functional<String, Integer> stringFunctional = String::length;
        System.out.println("String length is: " + stringFunctional.get("123456789"));

        // Java recognises common interfaces and as such, contains many useful interfaces in the API which is covered in chapter_4.FunctionalInterfaces
    }


}

@FunctionalInterface
interface Functional<T, U> {
    U get(T t);
}
