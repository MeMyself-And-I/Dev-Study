package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FoodFightTest {
    @Test
    public void testFoodFight() {

        FoodFight ff = new FoodFight();
        String result1 = ff.solution(new int[] { 1, 3, 4, 6 });
        String result2 = ff.solution(new int[] { 1, 7, 1, 2 });

        assertEquals("1223330333221", result1);
        assertEquals("111303111", result2);
    }
}
