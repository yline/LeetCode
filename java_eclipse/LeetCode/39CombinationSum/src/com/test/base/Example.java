package com.test.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.test.SolutionA;
import com.test.SolutionB;

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
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
    }
    
    private void assertSolution()
    {
        // A
        int[] candidatesA = {5, 6, 7};
        
        List<List<Integer>> expectA = new ArrayList<>();
        expectA.add(Arrays.asList(7));
        
        List<List<Integer>> actualA = solution.combinationSum(candidatesA, 7);
        assertEqualOfList(expectA, actualA);
        
        // B
        int[] candidatesB = {2, 3, 6, 7};
        
        List<List<Integer>> expectB = new ArrayList<>();
        expectB.add(Arrays.asList(2, 2, 3));
        expectB.add(Arrays.asList(7));
        
        List<List<Integer>> actualB = solution.combinationSum(candidatesB, 7);
        assertEqualOfList(expectB, actualB);
        
        // C
        int[] candidatesC = {2, 3, 5};
        
        List<List<Integer>> expectC = new ArrayList<>();
        expectC.add(Arrays.asList(2, 2, 2, 2));
        expectC.add(Arrays.asList(2, 3, 3));
        expectC.add(Arrays.asList(3, 5));
        
        List<List<Integer>> actualC = solution.combinationSum(candidatesC, 8);
        assertEqualOfList(expectC, actualC);
        
        // D
        int[] candidatesD = {2, 3, 7};
        List<List<Integer>> expectD = new ArrayList<>();
        expectD.add(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2));
        expectD.add(Arrays.asList(2, 2, 2, 2, 2, 2, 3, 3));
        expectD.add(Arrays.asList(2, 2, 2, 2, 3, 7));
        expectD.add(Arrays.asList(2, 2, 2, 3, 3, 3, 3));
        expectD.add(Arrays.asList(2, 2, 7, 7));
        expectD.add(Arrays.asList(2, 3, 3, 3, 7));
        expectD.add(Arrays.asList(3, 3, 3, 3, 3, 3));
        
        List<List<Integer>> actualD = solution.combinationSum(candidatesD, 18);
        assertEqualOfList(expectD, actualD);
    }
    
    private void assertEqualOfList(List<List<Integer>> expected, List<List<Integer>> actual)
    {
        assertEquals(expected.size(), actual.size());
        
        for (int i = 0; i < expected.size(); i++)
        {
            List<Integer> expectedList = expected.get(i);
            List<Integer> actualList = actual.get(i);
            
            System.out.println("i = " + i + ", expect = " + Arrays.toString(expectedList.toArray()) + ", actual = "
                + Arrays.toString(actualList.toArray()));
            assertEquals(expectedList.size(), actualList.size());
            
            Collections.sort(expectedList);
            Collections.sort(actualList);
            for (int j = 0; j < expectedList.size(); j++)
            {
                assertEquals(expectedList.get(j), actualList.get(j));
            }
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
