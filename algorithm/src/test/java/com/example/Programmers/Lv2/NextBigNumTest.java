package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NextBigNumTest {

    @Test
    public void testNextBigNum() {

        NextBigNum nbn = new NextBigNum();
        int result1 = nbn.solution(78);
        int result2 = nbn.solution(15);

        assertEquals(83, result1);
        assertEquals(23, result2);
    }
}
