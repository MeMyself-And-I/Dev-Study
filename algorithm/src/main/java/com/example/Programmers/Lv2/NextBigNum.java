package com.example.Programmers.Lv2;

/**
 * 프로그래머스 Lv2 - 다음 큰 숫자
 */
public class NextBigNum {
    public int solution(int n) {
        int oneLen = getOneLen(n);

        n++;
        while (oneLen != getOneLen(n)) {
            n++;
        }
        return n;
    }

    public int getOneLen(int n) {
        String nBinaryStr = Integer.toBinaryString(n);
        int oneRemovedLen = nBinaryStr.replace("1", "").length();
        return nBinaryStr.length() - oneRemovedLen;
    }
}
