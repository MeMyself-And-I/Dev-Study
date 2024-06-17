package com.example.Programmers.Lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 프로그래머스 Lv2 - 가장 큰 수
 * 정렬 문제 Comparator 인터페이스 compare 메소드 재정의 활용 풀이
 */
public class BiggestNum {
    public String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();
        List<String> list = new ArrayList<>();

        // 정렬할 리스트 초기화(String으로 형변환)
        for (int num : numbers) {
            list.add(num + "");
        }

        // Comparator를 사용한 사용자 정의 정렬
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 두 요소를 더했을 때 더 큰 숫자를 기준으로 내림차순 정렬
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        // 정답을 추출하기위해 리스트 내 문자열 더하기
        for (String a : list) {
            answer.append(a);
        }

        // 만약 정답이 0으로 시작한다면 답은 0이기 때문에 0리턴
        return answer.toString().startsWith("0") ? "0" : answer.toString();
    }
}
