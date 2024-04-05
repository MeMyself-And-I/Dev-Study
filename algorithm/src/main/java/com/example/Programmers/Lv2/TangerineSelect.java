package com.example.Programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 Lv2 - 귤 고르기
 */
public class TangerineSelect {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tanMap = new HashMap<>();

        // 값 초기화(중복값의 경우 +1 업데이트)
        for (int tan : tangerine) {
            tanMap.put(tan, tanMap.getOrDefault(tan, 0) + 1);
        }

        // 내림차순 정렬
        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(tanMap.entrySet());
        mapList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Integer, Integer> map : mapList) {
            answer++;
            k -= map.getValue();
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}
