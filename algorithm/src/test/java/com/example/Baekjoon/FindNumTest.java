package com.example.Baekjoon;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FindNumTest {
    @Test
    public void testFindNum() {

        FindNum fn = new FindNum();

        int[] originArr = { 4, 1, 5, 2, 3 };
        int[] targetArr = { 1, 3, 7, 9, 5 };
        int[] result1 = fn.binarySearch(originArr, targetArr);

        int[] expected = { 1, 1, 0, 0, 1 };

        assertArrayEquals(expected, result1);
    }
}
