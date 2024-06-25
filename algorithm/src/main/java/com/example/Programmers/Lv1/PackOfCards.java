package com.example.Programmers.Lv1;

/**
 * 프로그래머스 Lv1 - 카드 뭉치
 */
public class PackOfCards {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int idx1 = 0;
        int idx2 = 0;
        int length1 = cards1.length - 1;
        int length2 = cards2.length - 1;

        for (String part : goal) {
            if (idx1 <= length1 && cards1[idx1].equals(part)) {
                idx1++;
            } else if (idx2 <= length2 && cards2[idx2].equals(part)) {
                idx2++;
            } else {
                return "No";
            }
        }
        return answer;
    }
}
