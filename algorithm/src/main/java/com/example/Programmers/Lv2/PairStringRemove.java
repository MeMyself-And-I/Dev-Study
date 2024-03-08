package com.example.Programmers.Lv2;

import java.util.Stack;

/**
 * 프로그래머스 Lv2 - 짝지어 제거하기
 */
public class PairStringRemove {
    public int solution(String s) {
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();

        for (String ele : arr) {
            // 스택이 비어있지 않고, 스택의 top 값이 배열의 원소와 같을 때 스택에서 제거
            if (!stack.isEmpty() && stack.peek().equals(ele)) {
                stack.pop();
            } else {
                stack.push(ele);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
