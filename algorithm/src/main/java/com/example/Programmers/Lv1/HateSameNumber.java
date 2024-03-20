package com.example.Programmers.Lv1;

import java.util.Stack;

/**
 * 프로그래머스 Lv1 - 같은 숫자는 싫어
 */
public class HateSameNumber {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            }
            int ele = stack.peek();
            if (ele != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = 0; !stack.isEmpty(); i++) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
