package com.example.Baekjoon;

import java.util.ArrayList;
import java.util.List;

/**
 * 집합의 표현
 * 유니온 파인드 알고리즘으로 풀이
 */
public class SetExpression {

    static int[] parents;

    public List<String> doExpression(int n, int m, List<Operation> operations) {

        List<String> answer = new ArrayList<>();

        // 1. 대표 노드 초기화
        parents = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        // 2. 연산 처리(계산)
        for (Operation op : operations) {
            if (op.type == 0) { // 유니온 연산
                union(op.a, op.b);
            } else { // 두 원소 값 동일 체크
                answer.add(checkSame(op.a, op.b));
            }
        }

        return answer;
    }

    private void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if (findA != findB) {
            parents[b] = findA; // 두 개 그래프 연결
        }
    }

    private int find(int t) {
        if (parents[t] == t) {
            return t;
        } else {
            // value를 index로 변경해서 또 find 연산, parents[t]에 넣는 이유는 경로 압축을 위함
            return parents[t] = find(parents[t]);
        }
    }

    private String checkSame(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA == findB) {
            return "YES";
        } else {
            return "NO";
        }
    }
}

class Operation {

    int type;

    int a;

    int b;

    public Operation(int type, int a, int b) {
        this.type = type;
        this.a = a;
        this.b = b;
    }

}
