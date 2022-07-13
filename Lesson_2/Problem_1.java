package Lesson_2;

public class Problem_1 {
    public static void main(String[] args) {
        System.out.println("Argument summation\n");
        String input = "";
        int sum = 0;

        for(String str: args) {
            input += str + " ";
            sum += Integer.parseInt(str);
        }

        System.out.println("Input: " + input);
        System.out.println("Sum: " + sum);
    }
}
