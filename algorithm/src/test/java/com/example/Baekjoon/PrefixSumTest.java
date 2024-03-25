package com.example.Baekjoon;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PrefixSumTest {
    @Test
    public void testPrefixSum() {
        PrefixSum ps = new PrefixSum();
        int[] answer = ps.doPrefixSum(new int[] { 5, 8, 4, 3, 7, 2, 1, 6 }, 5, 10);

        int[] expectedTree = new int[] { 0, 39, 20, 19, 13, 7, 12, 7, 5, 8, 4, 3, 10, 2, 1, 6 };

        assertArrayEquals(expectedTree, answer);
    }
}
