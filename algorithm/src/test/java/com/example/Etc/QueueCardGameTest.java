package com.example.Etc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueCardGameTest {
    @Test
    public void queueCardGameTest() {

        QueueCardGame cardGame = new QueueCardGame();
        int result = cardGame.printLastCard(6);

        assertEquals(4, result);
    }
}
