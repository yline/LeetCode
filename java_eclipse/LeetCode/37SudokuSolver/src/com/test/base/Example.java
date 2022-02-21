package com.test.base;

import java.util.Arrays;

import com.test.SolutionA;
import com.test.SolutionC;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private static final char[][] EmptySudoku = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    
    private static final char[][] FullSudoku = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
        {'6', '7', '2', '1', '9', '5', '3', '4', '8'}, {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
        {'8', '5', '9', '7', '6', '1', '4', '2', '3'}, {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
        {'7', '1', '3', '9', '2', '4', '8', '5', '6'}, {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
        {'2', '8', '7', '4', '1', '9', '6', '3', '5'}, {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
    
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
        System.out.println("---------------------A----------------------------");
        
        char[][] sudokuTemp = deepClone(EmptySudoku);
        solution.solveSudoku(sudokuTemp);
        
        log(sudokuTemp);
        
        assertSolution(FullSudoku, sudokuTemp);
    }
    
    public void testSolutionC()
    {
        solution = new SolutionC();
        System.out.println("---------------------C----------------------------");
        
        char[][] sudokuTemp = deepClone(EmptySudoku);
        solution.solveSudoku(sudokuTemp);
        
        log(sudokuTemp);
        
        assertSolution(FullSudoku, sudokuTemp);
    }
    
    private void assertSolution(char[][] expect, char[][] actual)
    {
        assertEquals(expect.length, actual.length);
        
        for (int i = 0; i < actual.length; i++)
        {
            for (int j = 0; j < actual.length; j++)
            {
                if (expect[i][j] != actual[i][j])
                {
                    System.out.println("row = " + i + ", column = " + j);
                }
                assertEquals(expect[i][j], actual[i][j]);
            }
        }
    }
    
    private void log(char[][] expect)
    {
        for (int i = 0; i < expect.length; i++)
        {
            System.out.println(Arrays.toString(expect[i]));
        }
    }
    
    /**
     * 深度拷贝一个，默认的clone方法属于浅拷贝
     * @param expect
     * @return
     */
    private char[][] deepClone(char[][] expect)
    {
        char[][] result = new char[expect.length][expect[0].length];
        for (int i = 0; i < expect.length; i++)
        {
            for (int j = 0; j < expect[i].length; j++)
            {
                result[i][j] = expect[i][j];
            }
        }
        return result;
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
