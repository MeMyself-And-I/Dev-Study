package com.example.Programmers.Lv1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MockTestTest {
    @Test
    public void testMockTest() {

        MockTest mt = new MockTest();
        int[] result1 = mt.solution(new int[] { 1, 2, 3, 4, 5 });
        int[] result2 = mt.solution(new int[] { 1, 3, 2, 4, 2 });

        assertArrayEquals(new int[] { 1 }, result1);
        assertArrayEquals(new int[] { 1, 2, 3 }, result2);
    }
}
