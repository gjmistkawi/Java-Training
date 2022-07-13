package Lesson_5;

import java.util.Arrays;

public class Problem_5 {
    public static void main(String[] args) {
        int[] arr1 = {2,4,8};
        System.out.println(Arrays.toString(arr1) + " -> " + groupSumClump(0, arr1, 10));
        int[] arr2 = {1,2,4,8,1};
        System.out.println(Arrays.toString(arr2) + " -> " + groupSumClump(0, arr2, 14));
        int[] arr3  = {2,4,4,8};
        System.out.println(Arrays.toString(arr3) + " -> " + groupSumClump(0, arr3, 14));
    }

    public static boolean groupSumClump(int index, int[] arr, int target) {
        if(index >= arr.length) return (target == 0);

        int i = index;
        int sum = 0;

        while(i < arr.length && arr[index] == arr[i]) {
            sum += arr[i];
            i++;
        }

        if(groupSumClump(i, arr, (target - sum)))
            return true;

        if(groupSumClump(i, arr, target))
            return true;

        return false;
    }
}