package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FruitSalesManTest {
    @Test
    public void testFruitSalesMan() {
        FruitSalesMan f = new FruitSalesMan();

        int result1 = f.solution(3, 4, new int[] { 1, 2, 3, 1, 2, 3, 1 });
        int result2 = f.solution(4, 3, new int[] { 4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2 });

        assertEquals(8, result1);
        assertEquals(33, result2);
    }
}
