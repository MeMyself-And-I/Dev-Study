package com.example.Programmers.Lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 프로그래머스 Lv1 - 문자열 내 마음대로 정렬하기
 */
public class UserDefineStrSort {
    public String[] solution(String[] strings, int n) {

        List<Str> strList = new ArrayList<>();

        // 리스트 초기화
        for (int i = 0; i < strings.length; i++) {
            String ele = strings[i];
            strList.add(new Str(ele, String.valueOf(ele.charAt(n))));
        }

        // Comparator 재정의를 통한 Str 객체 비교
        // 같은 인덱스 문자를 가지고 있으면 해당 단어끼리 오름차순 정렬, 그렇지 않다면 idx끼리 오름차순 정렬
        Collections.sort(strList, new Comparator<Str>() {
            @Override
            public int compare(Str o1, Str o2) {
                if (o1.idx.equals(o2.idx)) {
                    return o1.word.compareTo(o2.word);
                } else {
                    return o1.idx.compareTo(o2.idx);
                }
            }
        });

        return strList.stream().map(x -> x.word).toArray(String[]::new);
    }
}

class Str {
    public String word;
    public String idx;

    Str(String word, String idx) {
        this.word = word;
        this.idx = idx;
    }
}
