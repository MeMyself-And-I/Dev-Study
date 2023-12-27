package com.example.Programmers.Lv1;

import java.util.Stack;

/**
 * 스택으로 오름차순 수열 만들기
 * 오름차순을 만들 수 있는 경우 push(+), pop(-)의 순서를 리턴
 * 오름차순을 만들 수 없는 경우 "No"를 리턴 
 */
public class StackAsc {
    public String ascSortStack(int[] sequence) {
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        StringBuffer bf = new StringBuffer();
        for(int i = 0; i < sequence.length; i++) {
            int su = sequence[i]; // 배열에서 i 인덱스의 값 대입
            if(su >= num) { // 수가 스택에 오름차순으로 쌓을 자연수보다 클 경우
                while (su >= num) { // 스택에 계속 push
                    stack.push(num++);
                    bf.append("+");
                }
                stack.pop();
                bf.append("-"); 
            } else {
                int n = stack.pop();
                if(n > su) { // pop연산으로 하나 제거했는데도 여전히 큰 경우 더이상 스택을 오름차순 정렬할 수 없기 때문에 로직 종료(스택은 후입선출 구조)
                    return "No";
                } else {
                    bf.append("-");
                }
            }
        }
        return bf.toString();
    }
}
