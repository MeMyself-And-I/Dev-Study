package com.example.Etc;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 카드게임2
 * 1. 큐의 front 삭제
 * 2. 다음 원소를 삭제 후 맨 뒤에 삽입
 * 3. 큐에 하나의 원소만 남아있을 경우 해당 원소 리턴
 */
public class QueueCardGame {
    public int printLastCard(int queueSize) {
        Queue<Integer> queue = new LinkedList<>();

        // 카드 생성
        for(int i = 1; i <= queueSize; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            // 제일 상단의 카드 제거
            queue.poll();
            int front = queue.poll();
            queue.add(front);
        }

        return queue.peek();
    }
}
