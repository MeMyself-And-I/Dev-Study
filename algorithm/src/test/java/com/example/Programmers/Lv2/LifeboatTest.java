package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LifeboatTest {
    @Test
    public void testLifeboat() {

        Lifeboat lb = new Lifeboat();

        int[] people1 = { 70, 50, 80, 50 };
        int result1 = lb.solution(people1, 100);

        int[] people2 = { 70, 80, 50 };
        int result2 = lb.solution(people2, 100);

        assertEquals(3, result1);
        assertEquals(3, result2);
    }
}
