package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @FunctionalInterface
    public interface Sequence {
        int Fib(int n);
    }
    public static class Problem_1 implements Sequence {
        public int Fib(int n) {
            return Stream.iterate(new int[] { 0, 1 }, p -> new int[] { p[1], p[0] + p[1] })
                    .limit(n)
                    .skip(n-1)
                    .findFirst()
                    .get()[1];
        }
    }

    public static class Problem_2 {
        public void sumWithNoInitialValue() {
            List<Integer> numbers = Arrays.asList(1, 2, 3);
            Optional<Integer> sum = sum(numbers);
            System.out.println(sum);
            // Optional[6]
        }

        public Optional<Integer> sum(List<Integer> numbers) {
            return numbers
                    .stream()
                    .reduce((a, b) -> (a + b));
        }
    }
}
