package com.example.Programmers.Lv1;

/**
 * 프로그래머스 Lv1 - 푸드 파이트 대회
 */
public class FoodFight {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int quotient = food[i] / 2;
            for (int j = 1; j <= quotient; j++) {
                sb.append(i);
            }
        }
        String origin = sb.toString();
        String reversed = sb.reverse().toString();
        answer = origin + "0" + reversed;
        return answer;
    }
}
