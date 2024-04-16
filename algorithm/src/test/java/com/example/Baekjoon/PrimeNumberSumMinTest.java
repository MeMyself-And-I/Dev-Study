package com.example.Baekjoon;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PrimeNumberSumMinTest {
    @Test
    public void testPrimeNumberSumMin() {
        PrimeNumberSumMin psm = new PrimeNumberSumMin();

        int[] result1 = psm.getPrimeNumberSumMin(60, 100);
        int[] result2 = psm.getPrimeNumberSumMin(64, 65);

        int[] expected1 = new int[] { 620, 61 };
        int[] expected2 = new int[] { -1 };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }
}
