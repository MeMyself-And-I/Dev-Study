package com.example.Programmers.Lv2;

/**
 * 프로그래머스 Lv2 - 멀리 뛰기
 */
public class LongJump {
    public long solution(int n) {
        long answer = 0;
        long prev = 1;
        long prevPrev = 0;

        for (int i = 1; i <= n; i++) {
            answer = (prev + prevPrev) % 1234567;
            prevPrev = prev;
            prev = answer;
        }

        return answer;
    }
}
