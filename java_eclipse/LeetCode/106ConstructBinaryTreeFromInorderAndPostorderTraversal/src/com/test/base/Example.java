package com.test.base;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
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
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertSolution();
    }
    
    private void assertSolution()
    {
        // A
        int[] preorderA = {3, 9, 20, 15, 7};
        int[] inorderA = {9, 3, 15, 20, 7};
        int[] postorderA = {9, 15, 7, 20, 3};
        
        TreeNode rootA = solution.buildTree(inorderA, postorderA);
        assertArrayEquals(preorderA, preBuild(rootA));
        
        // B
        //        int[] preorderB = {1, 2, 3};
        //        int[] inorderB = {2, 3, 1};
        //        TreeNode rootB = solution.buildTree(preorderB, inorderB);
        //        assertArrayEquals(preorderB, preBuild(rootB));
    }
    
    private int[] preBuild(TreeNode root)
    {
        List<Integer> preList = new ArrayList<>();
        dfs(root, preList);
        
        int[] result = new int[preList.size()];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = preList.get(i);
        }
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> preList)
    {
        if (null == root)
        {
            return;
        }
        
        preList.add(root.val);
        dfs(root.left, preList);
        dfs(root.right, preList);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
