package com.example.Programmers.Lv3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiskControllerTest {
    @Test
    public void testDiskController() {
        DiskController d = new DiskController();

        int result1 = d.solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } });
        int result2 = d.solution(new int[][] { { 0, 1 }, { 2, 2 }, { 2, 3 } });
        int result3 = d.solution(new int[][] { { 0, 3 }, { 2, 5 }, { 4, 2 } });

        assertEquals(9, result1);
        assertEquals(2, result2);
        assertEquals(5, result3);
    }
}
