package com.example.Programmers.Lv1;

/**
 * 프로그래머스 Lv1 - 크기가 작은 부분문자열 
 */
public class Substring {
    public int solution(String t, String p) {
        int answer = 0;
        long loopMax = t.length();
        long part = p.length();
        long index = 0;
        
        while(true) {
            // t String의 범위를 넘어갈 경우 반복 종료              
            if(index + part > loopMax) {
                break;
            }
            // 부분문자열 구한 후 p와 값 비교
            String result = t.substring((int) index, (int) (part + index));
            if(Long.parseLong(result) <= Long.parseLong(p)) {
                answer++;
            }
            index++;
        }
        return answer;
    }
}
