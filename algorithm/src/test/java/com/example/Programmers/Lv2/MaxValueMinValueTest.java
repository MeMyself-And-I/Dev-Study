package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxValueMinValueTest {
    @Test
    public void testMaxValueMinValue() {

        MaxValueMinValue mm = new MaxValueMinValue();
        String result1 = mm.solution("1 2 3 4");
        String result2 = mm.solution("-1 -2 -3 -4");
        String result3 = mm.solution("-1 -1");

        assertEquals("1 4", result1);
        assertEquals("-4 -1", result2);
        assertEquals("-1 -1", result3);
    }
}
