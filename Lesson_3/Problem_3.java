package Lesson_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Problem_3 {
    public static void main(String[] args) {
        String filePath = "/home/geoscow/work/server/temp/sample.txt";
        char c = args[0].charAt(0);
        System.out.println("File at '" + filePath + "'");
        System.out.println("Character " + c + " occurred " + countInstance(filePath,c) + " times");
    }

    public static int countInstance(String filePath, char c) {
        String current;
        char[] line;
        int count = 0;

        try {
            Scanner file = new Scanner(new File(filePath));
            while(file.hasNext()) {
                current = file.nextLine();
                line = current.toCharArray();
                for(char element: line) {
                    if(element == c)
                        count++;
                }
            }
        }

        catch(IOException e) {
            System.out.println("Exception: " + e);
        }

        return count;
    }
}
