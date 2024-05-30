package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrioTest {
    @Test
    public void testTrio() {
        Trio t = new Trio();

        int result1 = t.solution(new int[] { -2, 3, 0, 2, -5 });
        int result2 = t.solution(new int[] { -3, -2, -1, 0, 1, 2, 3 });
        int result3 = t.solution(new int[] { -1, 1, -1, 1 });

        assertEquals(2, result1);
        assertEquals(5, result2);
        assertEquals(0, result3);
    }
}
