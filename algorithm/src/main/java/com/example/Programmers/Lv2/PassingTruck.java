package com.example.Programmers.Lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 프로그래머스 Lv2 - 다리를 지나는 트럭
 * 큐 활용 풀이
 */
public class PassingTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 진입하게 되면 1초이므로 시간 1로 초기화
        int tick = 1;
        int totalWeight = 0;
        Queue<Truck> waitQueue = new LinkedList<>();
        Queue<Truck> processQueue = new LinkedList<>();
        Queue<Truck> finishQueue = new LinkedList<>();

        // 대기 큐 초기화
        for (int t : truck_weights) {
            waitQueue.add(new Truck(t, 0));
        }

        // 전체 트럭이 다리를 지날 때까지 반복
        while (finishQueue.size() != truck_weights.length) {
            Truck tempTruck = waitQueue.peek();
            // 현재 다리에 추가로 트럭이 들어갈 수 있는 경우(현재 다리에서 bridge_length개 미만의 트럭, 총 무게가 weight 이하의
            // 트럭이 있을 경우)
            if (tempTruck != null && processQueue.size() < bridge_length
                    && totalWeight + tempTruck.getWeight() <= weight) {
                Truck waitTruck = waitQueue.poll();
                waitTruck.move(); // 트럭 이동 거리 증가 후 processQueue에 삽입
                processQueue.add(waitTruck);
                // 불 필요한 반복문을 줄이기 위해 현재 총 트럭의 무게를 미리 계산
                totalWeight += waitTruck.getWeight();
            }
            List<Truck> toRemove = new ArrayList<>();
            // 현재 다리 위에 있는 트럭들이 다 지나 갔을 경우 완료 큐로 이동, 아닐 경우 이동 거리 1씩 증가
            for (Truck t : processQueue) {
                if (t.getDistance() >= bridge_length) {
                    totalWeight -= t.getWeight();
                    toRemove.add(t);
                    finishQueue.add(t);
                } else {
                    t.move();
                }
            }
            // 완료 큐로 이동한 트럭들을 processQueue에서 제거
            processQueue.removeAll(toRemove);
            tick++;
        }

        return tick;
    }
}

class Truck {
    private int weight;
    private int distance;

    public Truck(int weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move() {
        this.distance++;
    }
}
