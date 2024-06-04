package com.example.Programmers.Lv2;

import java.util.PriorityQueue;

/**
 * 프로그래머스 Lv2 - 더 맵게
 * 힙 자료구조를 구현한 우선순위 큐 클래스를 통한 풀이
 */
public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 우선순위 큐 초기화
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        // 큐가 빌 때까지 반복
        while (!pq.isEmpty()) {
            Integer lowScoville = pq.poll();
            if (lowScoville < K) {
                Integer nextLowScoville = pq.poll();
                // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우(섞기위한 다음 음식이 없을 떄)
                if (nextLowScoville == null) {
                    return -1;
                }
                Integer mixedScoville = lowScoville + (nextLowScoville * 2);
                pq.add(mixedScoville);
                answer++;
            }
        }

        return answer;
    }
}
