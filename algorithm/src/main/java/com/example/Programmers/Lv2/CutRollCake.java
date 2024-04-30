package com.example.Programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 Lv2 - 롤케이크 자르기 문제
 */
public class CutRollCake {
    public int solution(int[] topping) {
        int answer = 0;
        // 형, 동생 맵 선언
        Map<Integer, Integer> bigBro = new HashMap<>();
        Map<Integer, Integer> bro = new HashMap<>();

        // 형에게 모든 종류의 토핑을 추가(초기화)
        for (int i = 0; i < topping.length; i++) {
            if (bigBro.containsKey(topping[i])) {
                bigBro.replace(topping[i], bigBro.get(topping[i]) + 1);
            } else {
                bigBro.put(topping[i], 1);
            }
        }

        /**
         * 반복을 통하여 동생에게 토핑 추가, 형에게는 토핑 제거
         * 그 후 형, 동생의 토핑 개수를 비교하여 둘 다 동일하다면 정답 1증가
         */
        for (int i = 0; i < topping.length; i++) {
            // 동생에게 토핑 추가(토핑이 이미 있다면 개수 +1, 없다면 토핑 추가)
            if (bro.containsKey(topping[i])) {
                bro.replace(topping[i], bro.get(topping[i]) + 1);
            } else {
                bro.put(topping[i], 1);
            }

            // 형에게 토핑 제거(이미 한 개 이상있는 토핑이면 개수 -1, 없다면 토핑 삭제)
            if (bigBro.get(topping[i]) != 1) {
                bigBro.replace(topping[i], bigBro.get(topping[i]) - 1);
            } else {
                bigBro.remove(topping[i]);
            }

            // 둘의 토핑 종류 비교
            if (bigBro.size() == bro.size()) {
                answer++;
            }
        }

        return answer;
    }
}
