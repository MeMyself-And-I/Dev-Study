package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TangerineSelectTest {
    @Test
    public void testTangerineSelect() {

        TangerineSelect ts = new TangerineSelect();
        int result1 = ts.solution(6, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 });
        int result2 = ts.solution(4, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 });
        int result3 = ts.solution(2, new int[] { 1, 1, 1, 1, 2, 2, 2, 3 });

        assertEquals(3, result1);
        assertEquals(2, result2);
        assertEquals(1, result3);
    }
}
