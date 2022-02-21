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
        // A
        int[] candidatesA = {10, 1, 2, 7, 6, 1, 5};
        
        List<List<Integer>> expectA = new ArrayList<>();
        expectA.add(Arrays.asList(2, 6));
        expectA.add(Arrays.asList(1, 7));
        expectA.add(Arrays.asList(1, 2, 5));
        expectA.add(Arrays.asList(1, 1, 6));
        
        List<List<Integer>> actualA = solution.combinationSum2(candidatesA, 8);
        assertEqualOfList(expectA, actualA);
        
        // B
        int[] candidatesB = {2, 5, 2, 1, 2};
        
        List<List<Integer>> expectB = new ArrayList<>();
        expectB.add(Arrays.asList(5));
        expectB.add(Arrays.asList(1, 2, 2));
        
        List<List<Integer>> actualB = solution.combinationSum2(candidatesB, 5);
        assertEqualOfList(expectB, actualB);
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        // A
        int[] candidatesA = {10, 1, 2, 7, 6, 1, 5};
        
        List<List<Integer>> expectA = new ArrayList<>();
        expectA.add(Arrays.asList(1, 1, 6));
        expectA.add(Arrays.asList(1, 2, 5));
        expectA.add(Arrays.asList(1, 7));
        expectA.add(Arrays.asList(2, 6));
        
        List<List<Integer>> actualA = solution.combinationSum2(candidatesA, 8);
        assertEqualOfList(expectA, actualA);
        
        // B
        int[] candidatesB = {2, 5, 2, 1, 2};
        
        List<List<Integer>> expectB = new ArrayList<>();
        expectB.add(Arrays.asList(1, 2, 2));
        expectB.add(Arrays.asList(5));
        
        List<List<Integer>> actualB = solution.combinationSum2(candidatesB, 5);
        assertEqualOfList(expectB, actualB);
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
