package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BudgetTest {
    @Test
    public void budgetTest() {

        Budget budget = new Budget();
        int result1 = budget.solution(new int[] { 1, 3, 2, 5, 4 }, 9);
        int result2 = budget.solution(new int[] { 2, 2, 3, 3 }, 10);

        assertEquals(3, result1);
        assertEquals(4, result2);
    }
}
