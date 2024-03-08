package com.example.Programmers.Lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PairStringRemoveTest {

    @Test
    public void testPairStringRemove() {

        PairStringRemove psr = new PairStringRemove();
        int result1 = psr.solution("baabaa");
        int result2 = psr.solution("cdcd");

        assertEquals(1, result1);
        assertEquals(0, result2);
    }

}
