package com.example.Programmers.Lv1;

/**
 * 프로그래머스 Lv1 - 소수 찾기 문제
 * 에라토스테네스의 체 알고리즘으로 풀이
 */
public class FindPrimeNum {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        // 소수 배열 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // 소수가 아닌 수에 0 삽입
        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        // 소수이면(배열의 요소가 0이 아니면) 정답 변수에 +1
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                answer++;
            }
        }
        return answer;
    }
}
