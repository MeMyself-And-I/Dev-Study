package com.example.Baekjoon;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SetExpressionTest {
    @Test
    public void testSetExpression() {

        SetExpression se = new SetExpression();

        List<Operation> operations = Arrays.asList(
                new Operation(0, 1, 3),
                new Operation(1, 1, 7),
                new Operation(0, 7, 6),
                new Operation(1, 7, 1),
                new Operation(0, 3, 7),
                new Operation(0, 4, 2),
                new Operation(0, 1, 1),
                new Operation(1, 1, 1));

        String[] result1 = se.doExpression(7, 8, operations).stream().toArray(String[]::new);

        String[] expected = new String[] { "NO", "NO", "YES" };

        assertArrayEquals(expected, result1);
    }
}
