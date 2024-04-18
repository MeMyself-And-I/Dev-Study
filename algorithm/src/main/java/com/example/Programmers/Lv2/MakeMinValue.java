package com.example.Programmers.Lv2;

import java.util.Arrays;

/**
 * 프로그래머스 Lv2 - 최솟값 만들기
 * 정렬 문제
 */
public class MakeMinValue {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int loopLen = A.length - 1;
        for (int i = 0; i <= loopLen; i++) {
            answer += A[i] * B[loopLen - i];
        }

        return answer;
    }
}
