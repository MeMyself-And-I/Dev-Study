package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringDivideTest {
    @Test
    public void testStringDivide() {
        StringDivide s = new StringDivide();

        int result1 = s.solution("banana");
        int result2 = s.solution("abracadabra");
        int result3 = s.solution("aaabbaccccabba");

        assertEquals(3, result1);
        assertEquals(6, result2);
        assertEquals(3, result3);

    }
}
