package Lesson_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Problem_2 {
    public static void main(String[] args) {
        String filePath = "/home/geoscow/work/server/temp/sample.txt";
        String message = "some new text\n";

        appendToFile(filePath, message);
    }

    public static void appendToFile(String filePath, String message) {
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter(filePath, true));
            file.write(message);
            file.close();
        }

        catch(IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
