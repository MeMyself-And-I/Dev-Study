package com.example.Programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

public class Clothes {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            int clothesTypeIdx = clothes[i].length - 1;
            for (int j = 0; j < clothesTypeIdx; j++) {
                String clothesType = clothes[i][clothesTypeIdx];
                if (!map.containsKey(clothesType)) {
                    map.put(clothesType, 0);
                }
                map.replace(clothesType, map.get(clothesType) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue() + 1);
        }

        return answer - 1;
    }
}
