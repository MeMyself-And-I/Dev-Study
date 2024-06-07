package com.example.Programmers.Lv3;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class DoublePriorityQueueTest {
    @Test
    public void testDoublePriorityQueue() {
        DoublePriorityQueue dpq = new DoublePriorityQueue();

        int[] result1 = dpq.solution(new String[] { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" });
        int[] result2 = dpq
                .solution(new String[] { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" });

        int[] expected1 = new int[] { 0, 0 };
        int[] expected2 = new int[] { 333, -45 };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }
}
