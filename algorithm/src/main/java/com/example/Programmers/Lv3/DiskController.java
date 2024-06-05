package com.example.Programmers.Lv3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프로그래머스 Lv3 - 디스크 컨트롤러
 * Heap문제 우선순위 큐 활용 풀이
 */
public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;

        // 요청 시간 우선순위 큐 정렬 조건 설정(요청시간 오름차순)
        PriorityQueue<Job> requestPq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.getRequestTime() - o2.getRequestTime();
            }
        });
        // 소요 시간 우선순위 큐 정렬 조건 설정(소요시간 오름차순)
        PriorityQueue<Job> progressPq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.getProgressTime() - o2.getProgressTime();
            }
        });

        // 우선순위 큐 초기화
        for (int i = 0; i < jobs.length; i++) {
            requestPq.add(new Job(jobs[i][0], jobs[i][1]));
        }

        // 현재까지의 소요 시간 저장 변수
        int tick = 0;

        while (!requestPq.isEmpty() || !progressPq.isEmpty()) {
            // requestPq에서 뽑은 것이 tick이하인 job들만 뽑아서 progressPq에다가 넣기(현재 시점에 작업 가능한 job들)
            while (!requestPq.isEmpty()) {
                if (requestPq.peek().getRequestTime() <= tick) {
                    Job job = requestPq.poll();
                    progressPq.add(job);
                } else {
                    break;
                }
            }
            // 현재 tick이하인 job들이 들어 있는 progressPq에서 하나씩 뽑아 처리
            // 만약 현재 tick이하인 job이 없다면 시간 재조정
            if (progressPq.isEmpty()) {
                tick++;
            } else { // 현재 tick이하인 job이 있다면 처리 후 평균을 내기 위해 answer 변수에 합 연산 수행 및 현재 시점 재조정
                Job job = progressPq.poll();
                answer += tick + job.getTotalTime();
                tick += job.getProgressTime();
            }
        }
        answer /= jobs.length;
        return answer;
    }
}

class Job {
    private int requestTime;
    private int progressTime;
    private int totalTime;

    Job(int requestTime, int progressTime) {
        this.requestTime = requestTime;
        this.progressTime = progressTime;
        this.totalTime = progressTime - requestTime;
    }

    int getRequestTime() {
        return this.requestTime;
    }

    int getProgressTime() {
        return this.progressTime;
    }

    int getTotalTime() {
        return this.totalTime;
    }
}
