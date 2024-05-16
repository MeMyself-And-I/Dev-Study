package com.example.Programmers.Lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 프로그래머스 Lv1 - 두 개 뽑아서 더하기
 */
public class AddTwoElement {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();

        // 두 요소를 더해 treeSet에 추가(중복 방지 및 오름차순 정렬)
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // set의 요소들을 그대로 리스트에 추가
        for (Integer s : set) {
            answer.add(s);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
