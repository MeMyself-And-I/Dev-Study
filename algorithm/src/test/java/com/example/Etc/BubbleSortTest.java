package com.example.Etc;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void bubbleSortTest() {

        BubbleSort sort = new BubbleSort();

        // 정렬이 안되어 있는 경우
        int[] target1 = {5, 2, 3, 4, 1};
        int[] result1 = sort.sortAsc(target1);

        // 정렬이 되어 있는 경우
        int[] target2 = {1, 2, 3, 4, 5};
        int[] result2 = sort.sortAsc(target2);

        int[] expected = {1, 2, 3, 4, 5};

        assertArrayEquals(expected, result1);
        assertArrayEquals(expected, result2);
    }
}
