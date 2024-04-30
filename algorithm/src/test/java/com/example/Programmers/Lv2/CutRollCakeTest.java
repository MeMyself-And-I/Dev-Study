package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CutRollCakeTest {
    @Test
    public void testCutRollCake() {
        CutRollCake c = new CutRollCake();

        int result1 = c.solution(new int[] { 1, 2, 1, 3, 1, 4, 1, 2 });
        int result2 = c.solution(new int[] { 1, 2, 3, 1, 4 });

        assertEquals(2, result1);
        assertEquals(0, result2);
    }
}
