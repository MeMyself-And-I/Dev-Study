package com.example.Baekjoon;

/**
 * 백준 온라인 저지 2042 - 구간 합 구하기(세그먼트 트리 활용)
 */
public class PrefixSum {
    public int[] doPrefixSum(int[] numArr, int changeIndex, int changeNum) {
        // 1. 트리 초기화 하기
        int arrLen = numArr.length;
        int k = 1;
        for (int i = 1; i <= arrLen; i++) {
            k *= 2;
            if (k >= arrLen) {
                break;
            }
        }
        int treeLen = k * 2;
        int[] segTree = new int[treeLen];
        int startIdx = k;

        int idx = 0;
        // 리프노드 채우기
        for (int i = startIdx; i < treeLen; i++) {
            segTree[i] = numArr[idx];
            idx++;
        }

        // 채워진 리프노드로 구간 합 채우기
        for (int j = k - 1; j >= 1; j--) {
            segTree[j] = segTree[j * 2] + segTree[j * 2 + 1];
        }

        // 2. 데이터 업데이트 하기
        int treeChangeIdx = changeIndex + k - 1;

        segTree[treeChangeIdx] = changeNum;

        for (int q = treeChangeIdx; q > 1; q = q / 2) {
            if (q % 2 == 0) {
                segTree[q / 2] = segTree[q] + segTree[q + 1];
            } else {
                segTree[q / 2] = segTree[q] + segTree[q - 1];
            }
        }

        return segTree;
    }
}
