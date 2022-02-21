package com.test.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        solution = new SolutionA();
    }
    
    public void testSolution()
    {
        // A
        TreeNode rootA = new TreeNode(3);
        
        TreeNode aRight = new TreeNode(20);
        aRight.left = new TreeNode(15);
        aRight.right = new TreeNode(7);
        
        rootA.left = new TreeNode(9);
        rootA.right = aRight;
        
        List<List<Integer>> expectA = new ArrayList<>();
        expectA.add(Arrays.asList(3));
        expectA.add(Arrays.asList(9, 20));
        expectA.add(Arrays.asList(15, 7));
        
        assertTest(expectA, solution.levelOrder(rootA));
    }
    
    private void assertTest(List<List<Integer>> expect, List<List<Integer>> actual)
    {
        assertEquals(expect.size(), actual.size());
        
        for (int i = 0; i < expect.size(); i++)
        {
            assertEquals(expect.get(i).size(), actual.get(i).size());
            System.out.println("expect = " + Arrays.toString(expect.get(i).toArray()));
            System.out.println("actual = " + Arrays.toString(actual.get(i).toArray()));
            for (int j = 0; j < expect.get(i).size(); j++)
            {
                assertEquals(expect.get(i).get(j), actual.get(i).get(j));
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
