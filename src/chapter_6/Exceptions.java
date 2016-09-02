package chapter_6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by alexi on 2016/06/27.
 */
public class Exceptions {

    public static void main(String[] args) throws ArithmeticException, CustomException{

        try {
            System.out.println(5/0);
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println(5);
        }

        try {
            throw new CustomException("Custom exception thrown");
        } catch (CustomException custom ) {
            System.out.println(custom.getMessage());
        }

        List<String> list = null;

        try {
            for (String s : list)
                System.out.println(s);
        }catch (NullPointerException n) {
            list = new ArrayList<>(Collections.singletonList("Hello"));
            System.out.println("List is null, creating collection of type " + list.getClass());
            for(String s: list)
                System.out.print(s + " ");
        }

    }
}

class CustomException extends Exception {

    public CustomException() {
        super();
    }

    public CustomException(Exception e) {
        super(e);
    }

    public CustomException(String message) {
        super(message);
    }

}
