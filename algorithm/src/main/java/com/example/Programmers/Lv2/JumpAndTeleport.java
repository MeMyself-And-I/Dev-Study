package com.example.Programmers.Lv2;

/**
 * 프로그래머스 Lv2 - 점프와 순간이동
 */
public class JumpAndTeleport {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            // 2로 나눈 나머지가 0 -> 순간이동 했으니 배터리 소모가 없다
            if (n % 2 == 0) {
                n /= 2;
                // 2로 나눈 나머지가 0이 아님 -> 점프를 해야하니 배터리 1 소모
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}
