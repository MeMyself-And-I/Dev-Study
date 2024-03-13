package com.example.Programmers.Lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 Lv1 - 기사단원의 무기
 */
public class TemplarWeapon {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> cntList = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            int sqrt = (int) Math.sqrt(i);
            int cnt = 0;
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) { // 약수 중 작은 수 저장
                    cnt++;
                    if (i / j != j) { // 약수 중 큰 수 저장
                        cnt++;
                    }
                }
            }
            cntList.add(cnt);
        }

        for (Integer cnt : cntList) {
            answer += cnt > limit ? power : cnt;
        }
        return answer;
    }
}
