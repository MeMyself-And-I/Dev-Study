package com.example.Programmers.Lv1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class UserDefineStrSortTest {
    @Test
    public void testUserDefineStrSort() {
        UserDefineStrSort u = new UserDefineStrSort();

        String[] result1 = u.solution(new String[] { "sun", "bed", "car" }, 1);
        String[] result2 = u.solution(new String[] { "abce", "abcd", "cdx" }, 2);

        assertArrayEquals(new String[] { "car", "bed", "sun" }, result1);
        assertArrayEquals(new String[] { "abcd", "abce", "cdx" }, result2);
    }
}
