package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EngStrToNumStrTest {
    @Test
    public void engStrToNumStrTest() {

        EngStrToNumStr calc = new EngStrToNumStr();
        int result1 = calc.solution("one4seveneight");
        int result2 = calc.solution("23four5six7");
        int result3 = calc.solution("2three45sixseven");
        int result4 = calc.solution("123");

        assertEquals(1478, result1);
        assertEquals(234567, result2);
        assertEquals(234567, result3);
        assertEquals(123, result4);
    }
}
