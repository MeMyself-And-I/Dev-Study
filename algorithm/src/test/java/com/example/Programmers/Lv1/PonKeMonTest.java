package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PonKeMonTest {
    @Test
    public void nearSameWordTest() {
        PonKeMon p = new PonKeMon();
        int result1 = p.solution(new int[] { 3, 1, 2, 3 });
        int result2 = p.solution(new int[] { 3, 3, 3, 2, 2, 4 });
        int result3 = p.solution(new int[] { 3, 3, 3, 2, 2, 2 });

        assertEquals(2, result1);
        assertEquals(3, result2);
        assertEquals(2, result3);

    }
}
