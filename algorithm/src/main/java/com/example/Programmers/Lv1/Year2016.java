package com.example.Programmers.Lv1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

/**
 * 프로그래머스 Lv1 - 2016년
 * time 클래스를 활용한 풀이
 */
public class Year2016 {
    public String solution(int a, int b) {

        // 요일별 해당하는 번호를 가지고 있는 맵 초기화
        Map<Integer, String> dayMap = Map.of(
                1, "MON",
                2, "TUE",
                3, "WED",
                4, "THU",
                5, "FRI",
                6, "SAT",
                7, "SUN");

        // 해당 날짜의 LocalDate 객체를 구하고 요일을 추출(int형으로)
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();

        // 요일 리턴
        return dayMap.get(dayOfWeekNumber);
    }
}
