package com.test.base;

import java.util.Arrays;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private SolutionA solution;
    
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
        int[][] matrixA = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        printMatrix(matrixA);
        solution.setZeroes(matrixA);
        printMatrix(matrixA);
    }
    
    private void printMatrix(int[][] matrix)
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append('[');
        sBuilder.append('\n');
        for (int i = 0; i < matrix.length; i++)
        {
            sBuilder.append(Arrays.toString(matrix[i]));
            sBuilder.append('\n');
        }
        sBuilder.append(']');
        
        System.out.println(sBuilder.toString());
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
