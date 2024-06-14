package com.example.Programmers.Lv1;

/**
 * 프로그래머스 Lv1 - 최소직사각형
 * 완전탐색 문제 유형
 */
public class MinimumRectangle {
    public int solution(int[][] sizes) {
        int wMax = Integer.MIN_VALUE;
        int hMax = Integer.MIN_VALUE;

        // 명함 종류만큼 반복
        // 가로 길이에는 가로, 세로 중 가장 큰 값을 세로 길이에는 가로, 세로 중 가장 작은 값을 세팅
        for (int i = 0; i < sizes.length; i++) {
            // 명함의 가로, 세로 사이즈를 할당
            int w = sizes[i][0];
            int h = sizes[i][1];
            // 세로가 가로보다 길다면 가로로 눕히기(swap)
            if (h > w) {
                sizes[i][0] = h;
                sizes[i][1] = w;
            }

            // 각 가로, 세로에 더 큰 값이 나타난다면 max값 갱신
            if (sizes[i][0] > wMax) {
                wMax = sizes[i][0];
            }
            if (sizes[i][1] > hMax) {
                hMax = sizes[i][1];
            }
        }

        return wMax * hMax;
    }
}
