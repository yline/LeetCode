package com.test.base;

import java.util.ArrayList;
import java.util.List;

import com.test.SolutionA;
import com.test.SolutionB;

import junit.framework.TestCase;

public class Sample extends TestCase
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
        asserSolution();
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        asserSolution();
    }
    
    private void asserSolution()
    {
        int[] array1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = new ArrayList<>();
        result1.add(createList(-1, -1, 2));
        result1.add(createList(-1, 0, 1));
        assertEquals(result1, solution.threeSum(array1));
        
        int[] array2 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<List<Integer>> result2 = new ArrayList<>();
        result2.add(createList(0, 0, 0));
        assertEquals(result2, solution.threeSum(array2));
        
        int[] array3 = {-2, 0, 1, 1, 2};
        List<List<Integer>> result3 = new ArrayList<>();
        result3.add(createList(-2, 0, 2));
        result3.add(createList(-2, 1, 1));
        assertEquals(result3, solution.threeSum(array3));
        
        int[] array4 = {-1, 1, -1, 1};
        List<List<Integer>> result4 = new ArrayList<>();
        assertEquals(result4, solution.threeSum(array4));
        
        int[] array5 = {1, 2, -2, -1};
        List<List<Integer>> result5 = new ArrayList<>();
        assertEquals(result5, solution.threeSum(array5));
        
        int[] array6 = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> result6 = new ArrayList<>();
        // assertEquals(result6, solution.threeSum(array6));
        System.out.println(solution.threeSum(array6).toString());
        
        int[] array7 = {7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10,
            -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8,
            -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0,
            5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6};
        List<List<Integer>> result7 = new ArrayList<>();
        // assertEquals(result6, solution.threeSum(array6));
        System.out.println(solution.threeSum(array7).toString());
    }
    
    public List<Integer> createList(int one, int two, int three)
    {
        List<Integer> tempResult = new ArrayList<>();
        tempResult.add(one);
        tempResult.add(two);
        tempResult.add(three);
        return tempResult;
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
