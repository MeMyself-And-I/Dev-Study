package com.example.Programmers.Lv2;

/**
 * 프로그래머스 Lv2 - JadenCase 문자열 만들기
 */
public class JadenCase {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        String beforeStr = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                beforeStr = arr[i];
            }
            if (arr[i] == " ") {
                answer += arr[i];
            } else {
                boolean isNum = arr[i].replaceAll("[0-9]", "").length() == 0;
                if (isNum) {
                    answer += arr[i];
                } else if (!isNum && !beforeStr.equals(" ") && i == 0) {
                    answer += arr[i].toUpperCase();
                } else if (!isNum && !beforeStr.equals(" ")) {
                    answer += arr[i].toLowerCase();
                } else if (!isNum && beforeStr.equals(" ")) {
                    answer += arr[i].toUpperCase();
                }
                beforeStr = arr[i];
            }
        }

        return answer;
    }
}
