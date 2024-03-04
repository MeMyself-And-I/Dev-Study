package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CokeTest {
    @Test
    public void testCoke() {

        Coke coke = new Coke();
        int result1 = coke.solution(2, 1, 20);
        int result2 = coke.solution(3, 1, 20);

        assertEquals(19, result1);
        assertEquals(9, result2);
    }

}
