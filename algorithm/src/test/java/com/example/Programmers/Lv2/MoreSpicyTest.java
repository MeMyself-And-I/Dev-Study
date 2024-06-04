package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MoreSpicyTest {
    @Test
    public void testMoreSpicy() {
        MoreSpicy m = new MoreSpicy();

        int result1 = m.solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7);

        assertEquals(2, result1);
    }
}
