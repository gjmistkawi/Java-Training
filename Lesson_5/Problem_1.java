package Lesson_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int x);
}

class Checker {
    public static boolean checker(PerformOperation po, int x) {
        return po.check(x);
    }

    public PerformOperation isOdd() {
        return (x) -> {
            return (x % 2 == 1);
        };
    }

    public PerformOperation isPrime() {
        return (x) -> {
            for(int i = 2; i < Math.sqrt(x); i++)
                if(x % i == 0)
                    return false;
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return (x) -> {
            int rev = 0;
            int r = 0;
            int n = x;

            while(n != 0) {
                r = n % 10;
                rev = rev * 10 + r;
                n /= 10;
            }

            return (rev == x);
        };
    }
}

public class Problem_1 {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/geoscow/work/server/temp/lambda_test";

        Checker c = new Checker();
        BufferedReader file = new BufferedReader(new FileReader(filePath));
        int test_count = Integer.parseInt(file.readLine());

        PerformOperation op;
        String display = null;

        for(int i = 0; i < test_count; i++) {
            String s = file.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int option = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(option == 1) {
                op = c.isOdd();
                display = (c.checker(op, num)) ? "Odd" : "Even";
            }

            else if(option == 2) {
                op = c.isPrime();
                display = (c.checker(op, num)) ? "Prime" : "Non-Prime";
            }

            else if(option == 3) {
                op = c.isPalindrome();
                display = (c.checker(op, num)) ? "Palindrome" : "Non-Palindrome";
            }

            System.out.println(display);
        }
    }
}
