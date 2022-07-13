package Lesson_5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Problem_3 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 20);
        System.out.println("Original: " + nums.toString());
        List<Integer> results = doubling(nums);
        System.out.println("Results: " + results.toString());
    }

    public static List<Integer> doubling(List<Integer> nums) {
        return nums
                .stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
    }
}