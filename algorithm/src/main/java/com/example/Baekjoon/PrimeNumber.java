package com.example.Baekjoon;

import java.util.ArrayList;
import java.util.List;

/**
 * 백준 1929 소수 구하기
 * 에라토스테네스의 체 알고리즘으로 풀이
 * int M
 * int N
 * M이상 N이하의 소수를 구하기
 */
public class PrimeNumber {
    public int[] getPrimeNumber(int M, int N) {

        List<Integer> answer = new ArrayList<>();
        int[] pNumbers = new int[N + 1];

        // 배열 초기화
        for (int i = 0; i <= N; i++) {
            pNumbers[i] = i;
        }
        // 최대값(N)의 제곱근만큼 반복
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (pNumbers[i] == 0) {
                continue;
            }

            // 선택된 수의 배수를 삭제(0으로 업데이트)
            for (int j = i + i; j <= N; j = j + i) {
                pNumbers[j] = 0;
            }
        }

        for (int p = M; p < pNumbers.length; p++) {
            if (pNumbers[p] != 0) {
                answer.add(p);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
