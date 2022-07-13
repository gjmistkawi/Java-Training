package Lesson_5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Problem_2 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 224, 93, 3097);
        System.out.println("Original: " + nums.toString());
        List<Integer> results = rightDigit(nums);
        System.out.println("Results: " + results.toString());
    }

    public static List<Integer> rightDigit(List<Integer> nums) {
        return nums
                .stream()
                .map(x -> x % 10)
                .collect(Collectors.toList());
    }
}
