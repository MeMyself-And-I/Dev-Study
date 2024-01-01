package com.example.Baekjoon;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void selectionSortTest() {

        SelectionSort sort = new SelectionSort();

        int[] target1 = {2, 1, 4, 3};
        int[] result1 = sort.sortDesc(target1);

        int[] target2 = {9, 9, 9, 9, 9, 8, 9, 9, 9};
        int[] result2 = sort.sortDesc(target2);

        int[] expected1 = {4, 3, 2, 1};
        int[] expected2 = {9, 9, 9, 9, 9, 9, 9, 9, 8};

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }
}
