package com.test.base;

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
        int[] arrayA = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode rootA = solution.sortedArrayToBST(arrayA);
        assertSolutionLegal(rootA, arrayA.length);
        
        // B
        int[] arrayB = {-10, -3, 0, 5, 9};
        TreeNode rootB = solution.sortedArrayToBST(arrayB);
        assertSolutionLegal(rootB, arrayB.length);
    }
    
    private void assertSolutionLegal(TreeNode root, int length)
    {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        
        assertEquals(length, result.size());
        for (int i = 0; i < result.size() - 1; i++)
        {
            if (result.get(i) > result.get(i + 1))
            {
                assert false; // 失败
            }
        }
        assert true; // 成功
    }
    
    private void dfs(List<Integer> result, TreeNode root)
    {
        if (null == root)
        {
            return;
        }
        
        if (null != root.left)
        {
            dfs(result, root.left);
        }
        
        result.add(root.val);
        
        if (null != root.right)
        {
            dfs(result, root.right);
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
