package Lesson_5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Problem_4 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("ax", "bb", "cx", "xxax", "xbxbx");
        System.out.println("Original: " + words);
        List<String> results = noX(words);
        System.out.println("Results: " + results);
    }

    public static List<String> noX(List<String> words) {
        return words
                .stream()
                .map(s -> s.replaceAll("x",""))
                .collect(Collectors.toList());
    }
}
