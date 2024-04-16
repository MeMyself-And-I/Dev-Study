package com.example.Programmers.Lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 Lv3 - 베스트 앨범(해시)
 */
public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Album> albumMap = new HashMap<>();

        // 반복문을 돌며 장르를 키 값으로하여 해당 장르가 맵에 존재할 경우 필요한 데이터 업데이트, 존재하지 않을 경우 삽입
        for (int i = 0; i < genres.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(i, plays[i]);
            if (albumMap.containsKey(genres[i])) {
                Album album = albumMap.get(genres[i]);
                // 총 들은 횟수 더해주기
                album.setTotalPlay(album.getTotalPlay() + plays[i]);
                // 고유 번호가 key, 노래 별 들은 횟수가 value
                album.addPlay(map);
                // 내림차순으로 정렬
                album.sortPlays();
                // 업데이트된 값들 반영
                albumMap.replace(genres[i], album);
            } else {
                albumMap.put(genres[i], new Album(plays[i], Arrays.asList(map)));
            }
        }

        List<Map.Entry<String, Album>> list = new ArrayList<Map.Entry<String, Album>>(albumMap.entrySet());

        // 총 재생 횟수를 기준으로 내림차순 정렬(제일 많이 들은 장르 먼저 정답 배열에 넣기 위함)
        Collections.sort(list, new Comparator<Map.Entry<String, Album>>() {
            @Override
            public int compare(Map.Entry<String, Album> o1, Map.Entry<String, Album> o2) {
                return o2.getValue().getTotalPlay().compareTo(o1.getValue().getTotalPlay()); // 내림차순
            }
        });

        // 위에서 내림차순 정렬된 리스트를 순회하며 총 재생 횟수가 제일 많은 장르 중 개별 재생 횟수가 많은 순으로 고유 번호를 최대 2개까지 정답
        // 배열에 넣고,
        // 그 다음 총 재생 횟수가 제일 많은 장르 탐색하여 동일한 작업 수행
        for (Map.Entry<String, Album> m : list) {
            int cnt = 0;
            for (Map<Integer, Integer> p : m.getValue().getPlays()) {
                for (Map.Entry<Integer, Integer> n : p.entrySet()) {
                    if (cnt == 2) {
                        break;
                    }
                    answer.add(n.getKey());
                    cnt++;
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Album {
    private Integer totalPlay;
    private List<Map<Integer, Integer>> plays;

    public Album(int totalPlay, List<Map<Integer, Integer>> plays) {
        this.totalPlay = totalPlay;
        this.plays = new ArrayList<>(plays);
    }

    public Integer getTotalPlay() {
        return totalPlay;
    }

    public void setTotalPlay(int totalPlay) {
        this.totalPlay = totalPlay;
    }

    public List<Map<Integer, Integer>> getPlays() {
        return plays;
    }

    public void addPlay(Map<Integer, Integer> play) {
        this.plays.add(play);
    }

    public void sortPlays() {
        this.plays.sort((o1, o2) -> o2.values().iterator().next().compareTo(o1.values().iterator().next()));
    }
}
