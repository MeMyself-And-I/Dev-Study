package com.example.Programmers.Lv2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class StockPriceTest {
    @Test
    public void testStockPrice() {
        StockPrice sp = new StockPrice();

        int[] result = sp.solution(new int[] { 1, 2, 3, 2, 3 });

        int[] expected = new int[] { 4, 3, 1, 1, 0 };

        assertArrayEquals(expected, result);
    }
}
