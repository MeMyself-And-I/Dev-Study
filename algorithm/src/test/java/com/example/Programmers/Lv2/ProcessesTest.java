package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProcessesTest {
    @Test
    public void testProcesses() {
        Processes processes = new Processes();

        int result1 = processes.solution(new int[] { 2, 1, 3, 2 }, 2);
        int result2 = processes.solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0);

        assertEquals(1, result1);
        assertEquals(5, result2);
    }
}
