package com.example.Programmers.Lv1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class AddTwoElementTest {
    @Test
    public void testAddTwoElement() {
        AddTwoElement a = new AddTwoElement();

        int[] result1 = a.solution(new int[] { 2, 1, 3, 4, 1 });
        int[] result2 = a.solution(new int[] { 5, 0, 2, 7 });

        int[] expected1 = new int[] { 2, 3, 4, 5, 6, 7 };
        int[] expected2 = new int[] { 2, 5, 7, 9, 12 };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }
}
