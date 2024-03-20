package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongJumpTest {
    @Test
    public void testLongJump() {

        LongJump lj = new LongJump();
        long result1 = lj.solution(4);
        long result2 = lj.solution(3);

        assertEquals(5, result1);
        assertEquals(3, result2);
    }
}
