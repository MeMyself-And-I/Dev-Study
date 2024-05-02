package com.example.Programmers.Lv2;

import java.util.Arrays;

/**
 * 프로그래머스 Lv2 - 최댓값과 최솟값 리팩토링
 */
public class MaxValueMinValue_Refactor {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        int[] intArr = new int[sArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(sArr[i]);
        }

        Arrays.sort(intArr);

        answer = intArr[0] + " " + intArr[intArr.length - 1];

        return answer;
    }
}
