package com.example.Baekjoon;

/**
 * 백준 2581 소수
 * 에라토스테네스의 체 알고리즘으로 풀이
 * int M
 * int N
 * M이상 N이하의 소수를 구하여 소수들의 합과 최솟값을 리턴
 */
public class PrimeNumberSumMin {
    public int[] getPrimeNumberSumMin(int M, int N) {
        int[] arr = new int[N + 1];

        int sum = 0;
        int min = Integer.MAX_VALUE;

        // 배열 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // 2부터 시작
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        for (int i = M; i < arr.length; i++) {
            if (arr[i] != 0) {
                sum += arr[i];
            }
            if (arr[i] != 0 && arr[i] < min) {
                min = arr[i];
            }
        }

        // 소수가 있으면 합과 최솟값 리턴, 없으면 -1 리턴
        return sum != 0 ? new int[] { sum, min } : new int[] { -1 };
    }
}
