package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JadenCaseTest {
    @Test
    public void testJadenCase() {

        JadenCase jdc = new JadenCase();
        String result1 = jdc.solution("3people unFollowed me");
        String result2 = jdc.solution("for the last week");
        String result3 = jdc.solution("  for the what 1what  ");

        assertEquals("3people Unfollowed Me", result1);
        assertEquals("For The Last Week", result2);
        assertEquals("  For The What 1what  ", result3);
    }

}
