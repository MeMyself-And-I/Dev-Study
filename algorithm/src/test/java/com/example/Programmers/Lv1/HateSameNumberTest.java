package com.example.Programmers.Lv1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class HateSameNumberTest {
    @Test
    public void testHateSameNumber() {

        HateSameNumber hsn = new HateSameNumber();
        int[] result1 = hsn.solution(new int[] { 1, 1, 3, 3, 0, 1, 1 });
        int[] result2 = hsn.solution(new int[] { 4, 4, 4, 3, 3 });

        assertArrayEquals(new int[] { 1, 3, 0, 1 }, result1);
        assertArrayEquals(new int[] { 4, 3 }, result2);

    }
}
