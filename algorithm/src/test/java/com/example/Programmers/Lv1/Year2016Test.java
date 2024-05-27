package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Year2016Test {
    @Test
    public void testYear2016() {
        Year2016 y = new Year2016();

        String result1 = y.solution(5, 24);

        assertEquals("TUE", result1);
    }
}
