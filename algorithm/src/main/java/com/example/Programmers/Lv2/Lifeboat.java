package com.example.Programmers.Lv2;

import java.util.Arrays;

/**
 * 프로그래머스 Lv2 - 구명보트
 * 그리디 알고리즘으로 풀이
 * 오름차순 정렬하여 제일 무거운 사람과 제일 가벼운 사람의 무게의 합으로 두 명씩 구조하는게 제일 최적해라고 가정
 */
public class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int startIdx = 0;
        int endIdx = people.length - 1;

        // 오름차순 정렬
        Arrays.sort(people);

        while (startIdx <= endIdx) {
            // 제일 무거운 사람이 무게 제한을 넘을 경우
            if (people[endIdx] >= limit) {
                endIdx--;
            } else {
                int sum = people[startIdx] + people[endIdx];
                // 제일 무거운 사람과 제일 가벼운 사람의 합이 무게 제한을 넘을 경우 제일 무거운 사람만 구조
                if (sum > limit) {
                    endIdx--;
                    // 제일 무거운 사람과 제일 가벼운 사람의 합이 무게 제한을 넘지 않을 경우 두명 다 구조
                } else {
                    endIdx--;
                    startIdx++;
                }
            }
            answer++;
        }
        return answer;
    }
}
