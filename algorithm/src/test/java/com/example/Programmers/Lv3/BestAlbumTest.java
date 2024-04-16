package com.example.Programmers.Lv3;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BestAlbumTest {
    @Test
    public void testBestAlbum() {
        BestAlbum ba = new BestAlbum();

        int[] result1 = ba.solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
                new int[] { 500, 600, 150, 800, 2500 });
        int[] result2 = ba.solution(new String[] { "classic", "classic", "classic", "classic", "classic" },
                new int[] { 500, 600, 150, 800, 2500 });

        int[] expected1 = new int[] { 4, 1, 3, 0 };
        int[] expected2 = new int[] { 4, 3 };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }

}
