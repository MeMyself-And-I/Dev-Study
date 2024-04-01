package com.example.Baekjoon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Coin0Test {
    @Test
    public void testCoin0() {

        Coin0 c = new Coin0();

        int[] coins = { 1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000 };

        int result1 = c.getMinCoins(10, 4200, coins);
        int result2 = c.getMinCoins(10, 4790, coins);

        assertEquals(6, result1);
        assertEquals(12, result2);
    }
}
