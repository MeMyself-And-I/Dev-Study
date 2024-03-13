package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TemplarWeaponTest {
    @Test
    public void testTemplarWeapon() {

        TemplarWeapon tw = new TemplarWeapon();
        int result1 = tw.solution(5, 3, 2);
        int result2 = tw.solution(10, 3, 2);

        assertEquals(10, result1);
        assertEquals(21, result2);
    }
}
