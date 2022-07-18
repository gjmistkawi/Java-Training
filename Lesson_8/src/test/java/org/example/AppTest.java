package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    // You can't test a true lambda function because it is unnamed, so
    // I have created a named function with a lambda return to test
    @Test
    public void fibTest() {
        App.Problem_1 p1 = new App.Problem_1();
        assertEquals(1, p1.Fib(1));
        assertEquals(1, p1.Fib(2));
        assertEquals(2, p1.Fib(3));
        assertEquals(3, p1.Fib(4));
        assertEquals(5, p1.Fib(5));
    }

    // Pulled out the stream section into a seperate function for easier
    // testing and ease of access
    @Test
    public void prob2Test() {
        App.Problem_2 p2 = new App.Problem_2();
        List<Integer> numbers = Arrays.asList(1,2,3);
        assertEquals(6, p2.sum(numbers).get().intValue());
    }
}
