package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PassingTruckTest {
    @Test
    public void testPassingTruck() {
        PassingTruck pt = new PassingTruck();

        int result1 = pt.solution(2, 10, new int[] { 7, 4, 5, 6 });
        int result2 = pt.solution(100, 100, new int[] { 10 });
        int result3 = pt.solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 });

        assertEquals(8, result1);
        assertEquals(101, result2);
        assertEquals(110, result3);
    }
}
