package com.example.Programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 프로그래머스 Lv1 - K번째 수
 * 정렬 문제
 */
public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            int[] splited = new int[j - i + 1];
            int cnt = 0;
            for (int b = i - 1; b < j; b++) {
                splited[cnt] = array[b];
                cnt++;
            }
            Arrays.sort(splited);
            answer.add(splited[k - 1]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
