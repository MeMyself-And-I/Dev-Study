package com.example.Baekjoon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class LineupTest {
    @Test
    public void testLineup() {

        Lineup l = new Lineup();

        String result1 = l.topologySort(3, Arrays.asList(new Student(1, 3), new Student(2, 3)));
        String result2 = l.topologySort(4, Arrays.asList(new Student(4, 2), new Student(3, 1)));

        String expected1 = "123";

        assertEquals(expected1, result1);
        // 위상 정렬은 정답이 여러개일 수 있다.
        assertTrue(result2.equals("4231") ||
                result2.equals("3142") ||
                result2.equals("3412"));
    }
}
