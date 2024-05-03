package com.example.Programmers.Lv1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class HallOfFameTest {
    @Test
    public void testHallOfFame() {
        HallOfFame h = new HallOfFame();

        int[] result1 = h.solution(3, new int[] { 10, 100, 20, 150, 1, 100, 200 });
        int[] result2 = h.solution(4, new int[] { 0, 300, 40, 300, 20, 70, 150, 50, 500, 1000 });

        int[] expected1 = new int[] { 10, 10, 10, 20, 20, 100, 100 };
        int[] expected2 = new int[] { 0, 0, 0, 0, 20, 40, 70, 70, 150, 300 };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }
}
