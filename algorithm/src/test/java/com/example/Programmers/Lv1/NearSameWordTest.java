package com.example.Programmers.Lv1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class NearSameWordTest {

    @Test
    public void nearSameWordTest() {
        NearSameWord nsw = new NearSameWord();
        int[] result1 = nsw.solution("banana");
        int[] result2 = nsw.solution("foobar");

        int[] expected1 = { -1, -1, -1, 2, 2, 2 };
        int[] expected2 = { -1, -1, 1, -1, -1, -1 };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);

    }

}
