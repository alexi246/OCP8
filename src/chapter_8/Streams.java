package chapter_8;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alexi on 2016/07/09.
 * Note that these streams are the classic IO streams in Java and not the newer streams introduced in Java 8
 */
public class Streams {

    public static void main(String[] args) {

        password();
    }

    public static void password() {
        Console console = System.console();

        if (console == null)
            throw new RuntimeException("Console is not available");
        else {
            while (true) {
                char[] password = console.readPassword("Enter your password");
                console.format("Enter your password again");
                console.flush();
                char[] verify = console.readPassword();
                boolean match = Arrays.equals(password, verify);

                // clear passwords
                Arrays.fill(password, ' ');
                Arrays.fill(verify, ' ');

                console.format("Your password was: " + (match ? "correct" : "incorrect"));

                // break only if the passwords match, otherwise, continue asking user until the passwords match
                if(match)
                    break;
            }
        }
    }
}
