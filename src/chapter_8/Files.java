package chapter_8;


import java.io.*;

/**
 * Created by alexi on 2016/07/09.
 */
public class Files {

    public static void main(String[] args) {

        try {
            write(new BufferedWriter(new FileWriter("test.txt")));
        }catch (IOException io) {}

        try {
            read(new BufferedReader(new FileReader("test.txt")));
        }catch (IOException io) {}
    }

    private static void write(BufferedWriter bufferedWriter) throws IOException{

        bufferedWriter.write("Hi there");
        bufferedWriter.write("\nMy name is Jimmy Gonzalez");

        bufferedWriter.close();
    }

    private static void read(BufferedReader bufferedReader) throws IOException{

        String message;

        while((message = bufferedReader.readLine()) !=null) {
            System.out.println(message);
        }

        bufferedReader.close();
    }
}
