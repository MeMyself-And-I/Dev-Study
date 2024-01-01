package com.example.Etc;

/**
 * 백준 온라인 저지 1427 - 소트인사이드
 */
public class SelectionSort {
    public int[] sortDesc(int[] target) {
        // int to int[]
        int[] arr = target;

        for(int i = 0; i < arr.length; i++) {
            int maxIdx = i;
            // 내부 반복문을 통해 가장 큰 값이 있는 Index 찾기
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            // 비교할 첫번째 값과 찾은 가장 큰 값을 비교했을 때 찾은 가장 큰 값이 더 클 경우 swap
            if(arr[i] < arr[maxIdx]) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }
        return arr;
    }
}
