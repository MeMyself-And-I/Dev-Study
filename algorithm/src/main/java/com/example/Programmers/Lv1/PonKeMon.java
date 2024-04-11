package com.example.Programmers.Lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * 프로그래머스 Lv1 - 폰켓몬
 */
public class PonKeMon {
    public int solution(int[] nums) {
        int maxCnt = nums.length / 2;
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int minCnt = set.size();

        return Math.min(minCnt, maxCnt);
    }
}
