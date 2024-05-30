package com.example.Programmers.Lv1;

/**
 * 프로그래머스 Lv1 - 삼총사
 * 3중 for문으로 풀이(DFS 풀이도 가능하다)
 */
public class Trio {
    public int solution(int[] number) {
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == answer) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
