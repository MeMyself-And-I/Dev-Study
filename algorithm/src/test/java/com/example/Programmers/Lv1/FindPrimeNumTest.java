package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindPrimeNumTest {
    @Test
    public void testFindPrimeNum() {
        FindPrimeNum f = new FindPrimeNum();

        int result1 = f.solution(10);
        int result2 = f.solution(5);

        assertEquals(4, result1);
        assertEquals(3, result2);
    }
}
