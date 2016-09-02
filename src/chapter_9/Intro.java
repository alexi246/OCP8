package chapter_9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.lang.System.*;

/**
 * Created by alexi on 2016/07/10.
 */
public class Intro {

    public static void main(String[] args) {

        try {
            read(Paths.get("/home/alexi/Documents/c++.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(Path path) throws IOException {
        String message = new String(Files.readAllBytes(path));
        System.out.println(message);
    }
}
