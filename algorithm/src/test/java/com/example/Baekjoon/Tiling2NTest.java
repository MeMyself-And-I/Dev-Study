package com.example.Baekjoon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tiling2NTest {
    @Test
    public void testTiling2N() {
        Tiling2N t = new Tiling2N();

        int result1 = t.dp(2);
        int result2 = t.dp(9);

        assertEquals(2, result1);
        assertEquals(55, result2);
    }
}
