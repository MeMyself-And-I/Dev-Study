package com.example.Programmers.Lv2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class EngWordRelayTest {
    @Test
    public void testEngWordRelay() {

        EngWordRelay ewr = new EngWordRelay();

        String[] target1 = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
        int[] result1 = ewr.solution(3, target1);

        String[] target2 = { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
                "establish", "hang", "gather", "refer", "reference", "estimate", "executive" };
        int[] result2 = ewr.solution(5, target2);

        String[] target3 = { "hello", "one", "even", "never", "now", "world", "draw" };
        int[] result3 = ewr.solution(2, target3);

        int[] expected1 = { 3, 3 };
        int[] expected2 = { 0, 0 };
        int[] expected3 = { 1, 3 };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
        assertArrayEquals(expected3, result3);
    }
}
