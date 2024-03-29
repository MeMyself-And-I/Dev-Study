package com.example.Baekjoon;

import java.util.Arrays;

public class FindNum {
    public int[] binarySearch(int[] originArr, int[] targetArr) {
        // 이진 탐색을 하기 위해 오름차순 정렬
        Arrays.sort(originArr);

        int[] answer = new int[originArr.length];

        for (int i = 0; i < originArr.length; i++) {
            int startIdx = 0;
            int endIdx = originArr.length - 1;
            boolean find = false;
            int curIdx = i;
            while (startIdx <= endIdx) {
                int midIdx = (startIdx + endIdx) / 2;
                int midValue = originArr[midIdx];
                // 중간 값보다 찾으려는 값이 작을 경우
                if (midValue > targetArr[i]) {
                    endIdx = midIdx - 1;
                    // 중간 값보다 찾으려는 값이 클 경우
                } else if (midValue < targetArr[i]) {
                    startIdx = midIdx + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                answer[curIdx] = 1;
            } else {
                answer[curIdx] = 0;
            }
        }

        return answer;
    }
}
