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
        ListNode nodeA = buildListNode(1, 2, 3, 4, 5);
        ListNode resultA = solution.reverseBetween(nodeA, 2, 4);
        print(resultA);
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
