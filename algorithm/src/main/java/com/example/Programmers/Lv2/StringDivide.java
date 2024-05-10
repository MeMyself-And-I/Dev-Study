package com.example.Programmers.Lv2;

public class StringDivide {
    public int solution(String s) {
        int answer = 1;
        String sArr[] = s.split("");
        String x = sArr[0];
        int xCnt = 1;
        int notXCnt = 0;

        // 문자열을 한글자씩 나눈 배열을 반복문을 통해 순회
        for (int i = 1; i < sArr.length; i++) {
            // x의 개수와 x가 아닌 문자의 개수가 같아지게 된다면 정답 1 증가 및 다음 반복에 필요한 값 재설정
            if (xCnt == notXCnt) {
                answer++;
                xCnt = 0;
                notXCnt = 0;
                x = sArr[i];
            }
            String str = sArr[i];
            if (x.equals(str)) {
                xCnt++;
            } else {
                notXCnt++;
            }

        }
        return answer;
    }
}
