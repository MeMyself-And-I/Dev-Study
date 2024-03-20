package com.example.Programmers.Lv2;

/**
 * 프로그래머스 Lv2 - 피보나치 수
 */
public class Fibonacci {
    public int solution(int n) {
        int answer = 0;
        int prev = 1;
        int prevPrev = 0;
        for (int i = 2; i <= n; i++) {
            answer = (prev + prevPrev) % 1234567;
            prevPrev = prev;
            prev = answer;
        }

        return answer;
    }
}
