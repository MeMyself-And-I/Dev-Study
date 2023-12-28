package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubstringTest {
    @Test
    public void substringTest() {

        Substring ss = new Substring();
        int result1 = ss.solution("3141592", "271");
        int result2 = ss.solution("500220839878", "7");
        int result3 = ss.solution("10203", "15");

        assertEquals(2, result1);
        assertEquals(8, result2);
        assertEquals(3, result3);
    }
}
 