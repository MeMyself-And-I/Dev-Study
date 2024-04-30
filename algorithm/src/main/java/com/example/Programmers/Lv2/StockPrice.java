package com.example.Programmers.Lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 Lv2 - 주식가격 문제
 * 분류: 스택/큐
 */
public class StockPrice {
    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < prices.length - 1; i++) {
            int prevPrice = prices[i];
            int maintainSec = 0;
            for (int j = i + 1; j < prices.length; j++) {
                maintainSec++;
                if (prevPrice > prices[j]) {
                    break;
                }
            }
            answer.add(maintainSec);
        }
        answer.add(0);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
