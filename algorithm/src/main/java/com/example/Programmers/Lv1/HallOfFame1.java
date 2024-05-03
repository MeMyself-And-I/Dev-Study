package com.example.Programmers.Lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 프로그래머스 Lv1 - 명예의 전당
 */
public class HallOfFame1 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
            Collections.sort(list);
            if (list.size() > k) {
                list.remove(0);
            }
            answer[i] = list.get(0);
        }

        return answer;
    }
}
