package com.example.Programmers.Lv1;

import java.util.Arrays;

/**
 * 프로그래머스 Lv1 - 과일 장수 문제
 * 그리디 알고리즘 방식으로 풀이
 * 최적해 생각: 한 박스에 가장 낮은 점수의 사과를 기준으로 박스 가격를 구하기 때문에 최대한 낮은 점수는 낮은 점수끼리 모으면
 * 되겠다(정렬)
 */
public class FruitSalesMan {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int arrLen = score.length;
        int min = Integer.MAX_VALUE;
        int cnt = 1;
        // 오름차순 정렬
        Arrays.sort(score);

        for (int i = arrLen - 1; i >= 0; i--) {
            // 최소 점수 사과가 나오면 갱신
            if (min > score[i]) {
                min = score[i];
            }
            // 한 박스의 크기만큼 반복했다면 한 박스의 가격을 구해 정답에 더하기
            if (cnt == m) {
                answer += min * cnt;
                cnt = 0;
            }
            cnt++;
        }
        return answer;
    }
}
