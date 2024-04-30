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
        // 이중 for문을 통해 비교할 대상 요소(prevPrice)와 나머지 요소들을 비교하여 가격이 떨어지지 않은 기간(초)를 구한다.
        for (int i = 0; i < prices.length - 1; i++) {
            int prevPrice = prices[i];
            int maintainSec = 0;
            for (int j = i + 1; j < prices.length; j++) {
                maintainSec++;
                // 가격이 떨어졌을 경우 현재 대상과 비교 중지
                if (prevPrice > prices[j]) {
                    break;
                }
            }
            // 가격이 떨어지지 않은 기간(초)를 정답 리스트에 추가
            answer.add(maintainSec);
        }
        // 마지막의 경우 항상 0초간 가격이 떨어지지 않으므로 0을 추가
        answer.add(0);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
