package com.example.Programmers.Lv1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class KthNumberTest {
    @Test
    public void testKthNumber() {
        KthNumber k = new KthNumber();

        int[] result = k.solution(new int[] { 1, 5, 2, 6, 3, 7, 4 },
                new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } });

        int[] expected = new int[] { 5, 6, 3 };

        assertArrayEquals(expected, result);

    }
}
