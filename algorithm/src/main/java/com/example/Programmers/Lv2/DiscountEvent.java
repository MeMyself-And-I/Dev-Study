package com.example.Programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 Lv2 - 할인 행사
 */
public class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int loopCnt = discount.length;
        int total = 0;
        Map<String, Integer> wantMap = new HashMap<>();

        // 맵 및 제품 총 개수 초기화
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
            total += number[i];
        }

        // loopCnt - total + 1만큼 반복(제품 개수가 discount 길이 중 몇 번 반복할 수 있는지)
        for (int i = 0; i < loopCnt - total + 1; i++) {
            // 반복문에서 원본 맵 유지를 위해 생성자를 통한 복사
            Map<String, Integer> copyMap = new HashMap<String, Integer>(wantMap);
            for (int j = i; j < total + i; j++) {
                // 제한된 길이만큼 반복하면서 구매할 수 있으면(키가 존재하면) 카운트 - 1
                if (copyMap.containsKey(discount[j])) {
                    copyMap.replace(discount[j], copyMap.get(discount[j]) - 1);
                }
            }
            // 전체 제품 다 살 수 있는지 판별하는 변수
            boolean isAllDiscount = true;
            // 맵을 순회하며 못 산 제품이 있는지(0보다 큰지) 판별
            for (Map.Entry<String, Integer> m : copyMap.entrySet()) {
                if (m.getValue() > 0) {
                    isAllDiscount = false;
                }
            }
            if (isAllDiscount) {
                answer += 1;
            }
        }

        return answer;
    }
}
