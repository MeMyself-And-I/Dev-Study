package com.example.Programmers.Lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 프로그래머스 Lv2 - 프로세스 문제
 * 스택/큐 카테고리
 */
public class Processes {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> maxValList = new ArrayList<>();
        List<Process> answerList = new ArrayList<>();
        Queue<Process> queue = new LinkedList<>();

        // 큐 초기화
        for (int i = 0; i < priorities.length; i++) {
            maxValList.add(priorities[i]);
            if (i == location) {
                queue.add(new Process(priorities[i], true));
            } else {
                queue.add(new Process(priorities[i], false));
            }
        }

        // 우선순위 값이 높은 순서대로(내림차순) 정렬
        Collections.sort(maxValList, Collections.reverseOrder());

        while (!queue.isEmpty()) {
            Process process = queue.poll();
            // 현재 큐의 top부분의 우선순위가 최고 높은 우선순위와 같다면 정답 리스트에 추가
            if (process.priority == maxValList.get(0)) {
                answerList.add(process);
                // 그 다음 높은 값을 리스트 맨 앞에두기 위해 맨 앞 인덱스 삭제
                maxValList.remove(0);
                // 같지 않다면 다시 큐에 삽입
            } else {
                queue.add(process);
            }
        }

        for (int i = 0; i < answerList.size(); i++) {
            Process p = answerList.get(i);
            if (p.isTarget == true) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}

class Process {
    public int priority;
    public boolean isTarget;

    public Process(int priority, boolean isTarget) {
        this.priority = priority;
        this.isTarget = isTarget;
    }
}
