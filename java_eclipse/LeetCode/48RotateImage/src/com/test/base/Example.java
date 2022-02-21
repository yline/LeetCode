package com.test.base;

import static org.junit.Assert.assertArrayEquals;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertSolution();
    }
    
    private void assertSolution()
    {
        // A
        int[][] arrayA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] resultA = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        solution.rotate(arrayA);
        isEqual(resultA, arrayA);
        
        // B
        int[][] arrayB = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] resultB = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        solution.rotate(arrayB);
        isEqual(resultB, arrayB);
    }
    
    private void isEqual(int[][] expected, int[][] actual)
    {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
        {
            assertArrayEquals(expected[i], actual[i]);
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
