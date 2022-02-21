package com.test.base;

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
        ListNode rootA = buildListNode(1, 2, 3, 4, 5); // 长度为5，开始节点为4
        solution.rotateRight(rootA, 2);
        
        ListNode rootB = buildListNode(0, 1, 2); // 长度为3，开始节点为2
        solution.rotateRight(rootB, 4);
    }
    
    private ListNode buildListNode(int... array)
    {
        ListNode root = new ListNode(array[0]);
        ListNode temp = root;
        for (int i = 1; i < array.length; i++)
        {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        return root;
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
