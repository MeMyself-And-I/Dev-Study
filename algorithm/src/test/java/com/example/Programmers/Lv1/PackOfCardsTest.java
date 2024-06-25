package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PackOfCardsTest {
    @Test
    public void testPackOfCards() {
        PackOfCards p = new PackOfCards();

        String result1 = p.solution(new String[] { "i", "drink", "water" }, new String[] { "want", "to" },
                new String[] { "i", "want", "to", "drink", "water" });
        String result2 = p.solution(new String[] { "i", "water", "drink" }, new String[] { "want", "to" },
                new String[] { "i", "want", "to", "drink", "water" });

        assertEquals("Yes", result1);
        assertEquals("No", result2);
    }
}
