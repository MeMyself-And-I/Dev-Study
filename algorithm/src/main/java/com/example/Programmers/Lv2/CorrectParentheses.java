package com.example.Programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 Lv2 - 올바른 괄호
 */
public class CorrectParentheses {
    boolean solution(String s) {
        int cnt = 0;
        Queue<Character> queue = new LinkedList<Character>();

        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            if (c == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt < 0) {
                return false;
            }
        }

        if (cnt == 0) {
            return true;
        } else {
            return false;
        }
    }
}
