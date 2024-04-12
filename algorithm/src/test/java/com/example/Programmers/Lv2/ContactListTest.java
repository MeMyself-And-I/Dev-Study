package com.example.Programmers.Lv2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ContactListTest {
    @Test
    public void contactListTest() {
        ContactList c = new ContactList();

        boolean result1 = c.solution(new String[] { "119", "97674223", "1195524421" });
        boolean result2 = c.solution(new String[] { "123", "456", "789" });
        boolean result3 = c.solution(new String[] { "12", "123", "1235", "567", "88" });

        assertFalse(result1);
        assertTrue(result2);
        assertFalse(result3);

    }
}
