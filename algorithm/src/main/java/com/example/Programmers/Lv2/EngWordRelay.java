package com.example.Programmers.Lv2;

/**
 * 프로그래머스 Lv2 - 영어 끝말잇기
 */
public class EngWordRelay {
    public int[] solution(int n, String[] words) {
        boolean isSuccess = true;
        String beforeWord = words[0];
        int failTurn = 0;
        int personNum = 0;
        for (int i = 1; i < words.length; i++) {
            failTurn = (i / n) + 1;
            personNum = (i % n) + 1;

            if ((!words[i].startsWith(beforeWord.substring(beforeWord.length() - 1)))
                    || (words[i].length() == 1)
                    || isBeforeAppear(words, i, words[i])) {
                isSuccess = false;
                break;
            }

            beforeWord = words[i];
        }

        if (isSuccess) {
            return new int[] { 0, 0 };
        } else {
            return new int[] { personNum, failTurn };
        }
    }

    private boolean isBeforeAppear(String[] arr, int idx, String str) {
        for (int i = 0; i < idx; i++) {
            if (arr[i].equals(str)) {
                return true;
            }
        }
        return false;
    }
}
