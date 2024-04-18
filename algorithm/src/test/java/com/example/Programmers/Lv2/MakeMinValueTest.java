package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MakeMinValueTest {
    @Test
    public void testMakeMinValue() {

        MakeMinValue mmv = new MakeMinValue();

        int result1 = mmv.solution(new int[] { 1, 4, 2 }, new int[] { 5, 4, 4 });
        int result2 = mmv.solution(new int[] { 1, 2 }, new int[] { 3, 4 });

        int expected1 = 29;
        int expected2 = 10;

        assertEquals(expected1, result1);
        assertEquals(expected2, result2);

    }
}
