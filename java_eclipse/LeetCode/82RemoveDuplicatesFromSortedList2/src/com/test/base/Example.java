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
        ListNode nodeA = buildListNode(1, 2, 3, 3, 4, 4, 5);
        nodeA = solution.deleteDuplicates(nodeA);
        print(nodeA);
        
        ListNode nodeB = buildListNode(1, 1, 1, 2, 3);
        nodeB = solution.deleteDuplicates(nodeB);
        print(nodeB);
    }
    
    private ListNode buildListNode(int... array)
    {
        ListNode result = new ListNode(-1);
        
        ListNode temp = result;
        for (int i = 0; i < array.length; i++)
        {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        
        return result.next;
    }
    
    private void print(ListNode head)
    {
        StringBuilder sBuilder = new StringBuilder("->");
        ListNode temp = head;
        while (null != temp)
        {
            sBuilder.append(temp.val);
            sBuilder.append("->");
            temp = temp.next;
        }
        System.out.println(sBuilder.toString());
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
