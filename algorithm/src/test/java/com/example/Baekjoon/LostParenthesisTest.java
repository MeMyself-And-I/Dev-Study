package com.example.Baekjoon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LostParenthesisTest {
    @Test
    public void testLostParenthesis() {

        LostParenthesis lp = new LostParenthesis();

        String formula1 = "55-50+40";
        String formula2 = "10+20+30+40";
        String formula3 = "00009-00009";

        int result1 = lp.getMinByFormula(formula1);
        int result2 = lp.getMinByFormula(formula2);
        int result3 = lp.getMinByFormula(formula3);

        assertEquals(-35, result1);
        assertEquals(100, result2);
        assertEquals(0, result3);
    }
}
