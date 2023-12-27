package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackAscTest {
    @Test
    public void stackAscTest() {

        StackAsc stackAsc = new StackAsc();
        int[] sortableSeq = {4, 3, 6, 8, 7, 5, 2, 1}; // 정상 출력 케이스 수열에 해당
        int[] unsortableSeq = {5, 1, 2, 5, 3, 4}; // 오름차순 출력 실패 케이스 수열에 해당
        String result1 = stackAsc.ascSortStack(sortableSeq);
        String result2 = stackAsc.ascSortStack(unsortableSeq);

        assertEquals("++++--++-++-----", result1);
        assertEquals("No", result2);
    }
}
