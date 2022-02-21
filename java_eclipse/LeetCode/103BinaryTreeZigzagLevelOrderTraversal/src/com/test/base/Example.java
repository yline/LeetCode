package com.test.base;

import java.util.ArrayList;
import java.util.Arrays;
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
        TreeNode rootA = new TreeNode(3);
        
        TreeNode aRight = new TreeNode(20);
        aRight.left = new TreeNode(15);
        aRight.right = new TreeNode(7);
        
        rootA.left = new TreeNode(9);
        rootA.right = aRight;
        
        List<List<Integer>> expectA = new ArrayList<>();
        expectA.add(Arrays.asList(3));
        expectA.add(Arrays.asList(20, 9));
        expectA.add(Arrays.asList(15, 7));
        
        assertTest(expectA, solution.zigzagLevelOrder(rootA));
        
        // B
        TreeNode rootB = new TreeNode(1);
        
        TreeNode bLeft = new TreeNode(2);
        bLeft.left = new TreeNode(4);
        
        TreeNode bRight = new TreeNode(3);
        bRight.right = new TreeNode(5);
        
        rootB.left = bLeft;
        rootB.right = bRight;
        
        List<List<Integer>> expectB = new ArrayList<>();
        expectB.add(Arrays.asList(1));
        expectB.add(Arrays.asList(3, 2));
        expectB.add(Arrays.asList(4, 5));
        
        assertTest(expectB, solution.zigzagLevelOrder(rootB));
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
