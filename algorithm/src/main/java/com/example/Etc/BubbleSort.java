package com.example.Etc;

/**
 * 백준 온라인 저지 2750 - 수 정렬하기
 */
public class BubbleSort {
    public int[] sortAsc(int[] target) {
        int len = target.length;
        for(int i = 0; i < len - 1; i++) {
            boolean isSwaped = false;
            for(int j = 0; j < len - 1 - i; j++) {
                if(target[j] > target[j + 1]) {
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                    isSwaped = true;
                }
            }
            // 한 번의 라운드 동안 위치가 변경된 적이 없다면 이미 정렬이 되어있으므로 프로세스 종료
            if(isSwaped == false) {
                break;
            }
        }
        return target;
    }
}
