package com.example.Programmers.Lv1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrintTest {
    @Test
    public void printTest() {

        Print print = new Print();
        String result = print.prt();

        assertEquals("Hello World! 222", result);
    }
    
}
