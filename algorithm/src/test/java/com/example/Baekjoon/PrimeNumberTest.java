package com.example.Baekjoon;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PrimeNumberTest {
    @Test
    public void testPrimeNumber() {
        PrimeNumber p = new PrimeNumber();

        int[] result = p.getPrimeNumber(3, 16);

        assertArrayEquals(new int[] { 3, 5, 7, 11, 13 }, result);
    }
}
