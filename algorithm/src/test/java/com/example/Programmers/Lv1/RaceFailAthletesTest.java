package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RaceFailAthletesTest {
    @Test
    public void nearSameWordTest() {
        RaceFailAthletes rfa = new RaceFailAthletes();

        String result1 = rfa.solution(new String[] { "leo", "kiki", "eden" }, new String[] { "eden", "kiki" });
        String result2 = rfa.solution(new String[] { "marina", "josipa", "nikola", "vinko", "filipa" },
                new String[] { "josipa", "filipa", "marina", "nikola" });
        String result3 = rfa.solution(new String[] { "mislav", "stanko", "mislav", "ana" },
                new String[] { "stanko", "ana", "mislav" });

        assertEquals("leo", result1);
        assertEquals("vinko", result2);
        assertEquals("mislav", result3);

    }
}
