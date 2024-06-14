package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumRectangleTest {
    @Test
    public void testMinimumRectangle() {
        MinimumRectangle m = new MinimumRectangle();

        int result1 = m.solution(new int[][] { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } });
        int result2 = m.solution(new int[][] { { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } });
        int result3 = m.solution(new int[][] { { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 } });

        assertEquals(4000, result1);
        assertEquals(120, result2);
        assertEquals(133, result3);
    }
}
