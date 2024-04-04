package com.example.Programmers.Lv2;

/**
 * 프로그래머스 Lv2 - 최댓값과 최솟값
 */
public class MaxValueMinValue {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                min = Integer.parseInt(arr[i]);
                max = Integer.parseInt(arr[i]);
                continue;
            }
            if (Integer.parseInt(arr[i]) < min) {
                min = Integer.parseInt(arr[i]);
            }
            if (Integer.parseInt(arr[i]) > max) {
                max = Integer.parseInt(arr[i]);
            }

        }
        answer = min + " " + max;
        return answer;
    }
}
