package com.example.Programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 프로그래머스 Lv1 - 모의고사
 */
public class MockTest {
    public int[] solution(int[] answers) {
        LinkedList<Integer> man1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> man2 = new LinkedList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        LinkedList<Integer> man3 = new LinkedList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        List<SupoMan> supoMans = Arrays.asList(new SupoMan(man1, 0), new SupoMan(man2, 0), new SupoMan(man3, 0));
        for (int answer : answers) {
            for (SupoMan supoMan : supoMans) {
                Integer num = supoMan.man.poll();
                if (answer == num) {
                    supoMan.score++;
                }
                supoMan.man.add(num);
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for (SupoMan supoMan : supoMans) {
            if (supoMan.score > maxVal) {
                maxVal = supoMan.score;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < supoMans.size(); i++) {
            if (supoMans.get(i).score == maxVal) {
                answer.add(i + 1); // 인덱스를 넣는 것이 아닌 사람을 넣어야 하므로 +1
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    class SupoMan {
        private Queue<Integer> man;
        private Integer score;

        public SupoMan(Queue<Integer> man, Integer score) {
            this.man = man;
            this.score = score;
        }
    }
}
