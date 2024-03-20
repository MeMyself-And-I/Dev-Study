package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testFibonacci() {

        Fibonacci f = new Fibonacci();
        int result1 = f.solution(3);
        int result2 = f.solution(5);

        assertEquals(2, result1);
        assertEquals(5, result2);
    }
}
