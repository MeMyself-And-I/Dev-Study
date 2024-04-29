package com.example.Programmers.Lv2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FuncDevTest {
    @Test
    public void testFuncDev() {
        FuncDev fd = new FuncDev();

        int[] result1 = fd.solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
        int[] result2 = fd.solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 });

        int[] expected1 = new int[] { 2, 1 };
        int[] expected2 = new int[] { 1, 3, 2 };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }
}
