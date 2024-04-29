package com.example.Programmers.Lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 Lv2 - 기능개발 문제
 * 분류: 스택/큐
 */
public class FuncDev {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int len = progresses.length;
        List<Integer> list = new ArrayList<>();
        // 반복문을 통해서 개발 완료까지의 소요 일자를 구하여 리스트에 추가
        for (int i = 0; i < len; i++) {
            // 남은 진도율
            double needProgress = 100 - progresses[i];
            // 개발 속도
            double speed = speeds[i];
            // 올림을 통하여 개발 완료 소요 일자를 구함
            int needDay = (int) Math.ceil(needProgress / speed);
            list.add(needDay);
        }

        // 이전 개발완료 일자
        int before = list.get(0);
        // 하루에 몇 개의 기능을 배포할 수 있는지를 저장할 카운트 변수
        int cnt = 1;
        for (int i = 1; i < list.size(); i++) {
            // before의 기능 개발이 우선되어야 다음 기능들을 배포할 수 있는 경우
            if (before >= list.get(i)) {
                cnt++;
            } else { // before의 기능 개발이 완료 된 경우 그동안의 카운트한 총 배포할 기능 개수를 정답 리스트에 추가
                answer.add(cnt);
                cnt = 1;
                before = list.get(i);
            }
        }
        // 마지막 남은 배포 기능 갯수 추가
        answer.add(cnt);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
