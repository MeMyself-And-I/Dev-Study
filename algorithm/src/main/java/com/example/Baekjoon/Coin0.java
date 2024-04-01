package com.example.Baekjoon;

/**
 * 동전 0
 * 그리디 알고리즘으로 풀이
 * int N -> 보유 동전 개수(배열 A의 길이)
 * int K -> 목표 금액
 * int[] A -> 동전 금액 배열
 */
public class Coin0 {
    public int getMinCoins(int N, int K, int[] A) {
        int coinCnt = 0;

        // 오름차순 정렬이니 제일 비싼 가격부터 순회
        for (int i = N - 1; i >= 0; i--) {
            // 배열 요소 중 목표 가격보다 바로 작거나 같은 가격이 나왔다면
            if (A[i] <= K) {
                // 코인 개수 증가
                coinCnt += K / A[i];
                // 남은 채울 금액 할당
                K = K % A[i];
            }
        }

        return coinCnt;
    }
}
