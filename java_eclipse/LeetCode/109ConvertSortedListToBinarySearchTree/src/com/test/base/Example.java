package com.test.base;

import java.util.ArrayList;
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
        ListNode temp;
        
        // A
        ListNode nodeA = new ListNode(1);
        temp = nodeA;
        
        temp.next = new ListNode(2);
        temp = temp.next;
        
        temp.next = new ListNode(3);
        temp = temp.next;
        
        temp.next = new ListNode(4);
        temp = temp.next;
        
        temp.next = new ListNode(5);
        temp = temp.next;
        
        temp.next = new ListNode(6);
        temp = temp.next;
        
        temp.next = new ListNode(7);
        temp = temp.next;
        
        temp.next = new ListNode(8);
        temp = temp.next;
        
        temp.next = new ListNode(9);
        temp = temp.next;
        TreeNode rootA = solution.sortedListToBST(nodeA);
        assertSolutionLegal(rootA);
        
        // B
        ListNode nodeB = new ListNode(-10);
        temp = nodeA;
        
        temp.next = new ListNode(-3);
        temp = temp.next;
        
        temp.next = new ListNode(0);
        temp = temp.next;
        
        temp.next = new ListNode(5);
        temp = temp.next;
        
        temp.next = new ListNode(9);
        temp = temp.next;
        TreeNode rootB = solution.sortedListToBST(nodeB);
        assertSolutionLegal(rootB);
    }
    
    private void assertSolutionLegal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        
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
