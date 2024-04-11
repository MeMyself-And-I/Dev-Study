package com.example.Programmers.Lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 Lv1 - 완주하지 못한 선수
 */
public class RaceFailAthletes {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> pMap = new HashMap<>();
        for (String part : participant) {
            if (pMap.containsKey(part)) {
                pMap.replace(part, pMap.get(part) + 1);
            } else {
                pMap.put(part, 1);
            }
        }

        for (String comp : completion) {
            if (pMap.containsKey(comp)) {
                pMap.replace(comp, pMap.get(comp) - 1);
            }
        }

        for (Map.Entry<String, Integer> entry : pMap.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}
