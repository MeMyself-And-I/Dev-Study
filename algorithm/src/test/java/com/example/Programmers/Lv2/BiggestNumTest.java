package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BiggestNumTest {
    @Test
    public void testBiggestNum() {
        BiggestNum b = new BiggestNum();

        String result1 = b.solution(new int[] { 6, 10, 2 });
        String result2 = b.solution(new int[] { 3, 30, 34, 5, 9 });
        String result3 = b.solution(new int[] { 0, 0, 0 });

        assertEquals("6210", result1);
        assertEquals("9534330", result2);
        assertEquals("0", result3);
    }
}
