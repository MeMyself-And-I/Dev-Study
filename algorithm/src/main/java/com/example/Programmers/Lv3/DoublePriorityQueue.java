package com.example.Programmers.Lv3;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 프로그래머스 Lv3 - 이중우선순위큐
 * Heap문제 우선순위 큐 활용 풀이
 */
public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String s : operations) {
            String[] sArr = s.split(" ");
            switch (sArr[0]) {
                // 삽입 연산
                case "I":
                    pq.add(Integer.parseInt(sArr[1]));
                    break;
                // 삭제 연산
                case "D":
                    if (!pq.isEmpty()) {
                        // 최소값 삭제
                        if (sArr[1].equals("-1")) {
                            pq.remove();
                            // 최대값 삭제
                        } else {
                            pq = removeMax(pq);
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        if (!pq.isEmpty()) {
            // 최소값 정답 배열에 삽입
            answer[1] = pq.poll();
            PriorityQueue<Integer> descPq = new PriorityQueue<>(Collections.reverseOrder());
            while (!pq.isEmpty()) {
                descPq.add(pq.poll());
            }
            // 최대값 정답 배열에 삽입
            answer[0] = descPq.poll();
        }
        return answer;
    }

    // 최대값 삭제 메소드
    private PriorityQueue<Integer> removeMax(PriorityQueue<Integer> pq) {
        PriorityQueue<Integer> descPq = new PriorityQueue<>(Collections.reverseOrder());

        // 내림차순 우선순위 큐에 내림차순으로 정렬되어 있는 데이터를 재정렬
        while (!pq.isEmpty()) {
            descPq.add(pq.poll());
        }
        // 가장 큰 값 삭제후 다시 내림차순 정렬하여 리턴
        descPq.remove();
        PriorityQueue<Integer> newPq = new PriorityQueue<>();
        while (!descPq.isEmpty()) {
            newPq.add(descPq.poll());
        }

        return newPq;
    }
}
