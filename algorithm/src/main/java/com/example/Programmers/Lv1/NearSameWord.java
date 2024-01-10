package com.example.Programmers.Lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 Lv1 - 가장 가까운 같은 글자
 */
public class NearSameWord {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] arr = s.split("");
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Integer val = map.get(arr[i]);
            map.put(arr[i], i);
            if (val == null) {
                answer[i] = -1;
            } else {
                answer[i] = i - val;
            }
        }
        return answer;
    }
}
