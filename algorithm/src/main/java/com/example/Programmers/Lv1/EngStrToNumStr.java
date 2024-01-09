package com.example.Programmers.Lv1;

/**
 * 프로그래머스 Lv1 - 숫자 문자열과 영단어
 */
public class EngStrToNumStr {
    public int solution(String s) {
        int answer = 0;
        String[] num = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for (int i = 0; i < 10; i++) {
            s = s.replace(num[i], Integer.toString(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}
