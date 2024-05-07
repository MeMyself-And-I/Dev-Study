package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiscountEventTest {
    @Test
    public void testDiscountEvent() {
        DiscountEvent d = new DiscountEvent();

        int result1 = d.solution(new String[] { "banana", "apple", "rice", "pork", "pot" }, new int[] { 3, 2, 2, 2, 1 },
                new String[] { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                        "pot", "banana", "apple", "banana" });
        int result2 = d.solution(new String[] { "apple" }, new int[] { 10 }, new String[] { "banana", "banana",
                "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana" });

        assertEquals(3, result1);
        assertEquals(0, result2);
    }
}
