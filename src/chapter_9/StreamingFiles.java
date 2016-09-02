package chapter_9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by alexi on 2016/07/12.
 * Listing file and directory information using the new Java 8 stream API
 */
public class StreamingFiles {

    public static void main(String[] args) {
        Path path = Paths.get("/", "home", "alexi", "Documents", "c++.txt");

        try {
            listingDirContents(Paths.get("/home/alexi/Documents"));
            printFileContents(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void walking(Path path) throws IOException {
        Files.walk(path)
                .filter((p) -> p.toString().endsWith(".java"))
                .forEach(System.out::println);
    }

    public static void searching(Path path) throws IOException {
        long dateFilter = 1420070400000L;

        Stream<Path> stream = Files.find(path, 10, (p, a) -> p.toString()
                .endsWith(".java") && a.lastModifiedTime()
                .toMillis() > dateFilter);

        stream.forEach(System.out::println);
    }

    public static void listingDirContents(Path path) throws IOException {
        Files.list(path)
                .filter((p) -> !Files.isDirectory(p))
                .map(Path::toAbsolutePath)
                .forEach(System.out::println);
    }

    public static void printFileContents(Path path) throws IOException {
        // Print all contents of the file

        Files.lines(path).forEach(System.out::println);

        // Print file contents based on certain criteria

        /*System.out.println(Files.lines(path)
                .filter(s -> s.startsWith("Something "))
                .map(s -> s.substring(10))
                .collect(Collectors.toList()));*/
    }
}
