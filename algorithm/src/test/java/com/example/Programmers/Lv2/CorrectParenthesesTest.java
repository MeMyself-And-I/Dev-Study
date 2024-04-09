package com.example.Programmers.Lv2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CorrectParenthesesTest {
    @Test
    public void testCorrectParentheses() {

        CorrectParentheses cp = new CorrectParentheses();

        boolean result1 = cp.solution("()()");
        boolean result2 = cp.solution("(())()");
        boolean result3 = cp.solution(")()(");
        boolean result4 = cp.solution("(()(");

        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertFalse(result4);
    }
}
