package com.example.Baekjoon;

/**
 * 백준 온라인 저지 11726 - 2 * n 타일링
 * 동적 계획법 사용하여 풀이
 */
public class Tiling2N {
    public int dp(int tileWidth) {
        int[] D = new int[tileWidth + 1];

        // 가장 작은 문제 초기화
        D[1] = 1; // 너비가 1의 직사각형의 경우 1 * 2 또는 2 * 1 타일로 채울 수 있는 경우의 수는 1개
        D[2] = 2; // 너비가 2의 직사각형의 경우 1 * 2 또는 2 * 1 타일로 채울 수 있는 경우의 수는 2개

        /**
         * 바텀업 방식으로 풀이
         * 점화식 D[N] = D[N - 1] + D[N - 2]
         */
        for (int i = 3; i < D.length; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 10007;
        }

        return D[tileWidth];
    }
}
