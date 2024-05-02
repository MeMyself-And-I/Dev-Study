package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JumpAndTeleportTest {
    @Test
    public void testJumpAndTeleport() {
        JumpAndTeleport j = new JumpAndTeleport();

        int result1 = j.solution(5);
        int result2 = j.solution(6);
        int result3 = j.solution(5000);

        assertEquals(2, result1);
        assertEquals(2, result2);
        assertEquals(5, result3);
    }
}
