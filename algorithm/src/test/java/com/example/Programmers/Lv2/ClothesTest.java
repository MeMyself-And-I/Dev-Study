package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClothesTest {
    @Test
    public void testClothes() {
        Clothes c = new Clothes();

        int result1 = c.solution(new String[][] { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
                { "green_turban", "headgear" } });
        int result2 = c.solution(
                new String[][] { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } });

        assertEquals(5, result1);
        assertEquals(3, result2);

    }
}
