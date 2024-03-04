package com.example.Programmers.Lv1;

/**
 * 프로그래머스 Lv1 - 콜라 문제
 */
public class Coke {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int mod = n;

        while (mod >= a) {
            int refill = mod / a * b;
            mod = mod % a + refill;
            answer += refill;
        }

        return answer;
    }
}
