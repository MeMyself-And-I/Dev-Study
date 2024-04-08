package com.example.Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 줄 세우기
 * 위상 정렬 알고리즘으로 풀이
 * int N -> 학생의 수
 * List<Student> students -> 키를 비교한 두 학생의 번호 A, B가 들어있는 리스트(학생 A가 학생 B의 앞에 서야한다는
 * 의미)
 */
public class Lineup {
    public String topologySort(int N, List<Student> students) {
        String answer = "";

        // 1. 진입차수 배열과 인접 리스트 데이터 초기화
        ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            aList.add(new ArrayList<>());
        }

        for (Student stu : students) {
            int start = stu.A;
            int end = stu.B;
            aList.get(start).add(end);
            inDegree[end]++; // 진입차수 데이터 저장
        }

        Queue<Integer> queue = new LinkedList<>();

        // 2. 위상 정렬 실행
        for (int i = 1; i <= N; i++) {
            // 진입 차수가 0이면 큐에 삽입
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐가 비어있지 않으면 계속 실행
        while (!queue.isEmpty()) {
            int now = queue.poll();
            answer += now;
            for (int next : aList.get(now)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return answer;
    }
}

class Student {

    int A;
    int B;

    public Student(int A, int B) {
        this.A = A;
        this.B = B;
    }
}
