package com.test.base;

import com.test.SolutionA;
import com.test.SolutionB;

import junit.framework.TestCase;

public class Sample extends TestCase
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
        ListNode node0 = newListNode(new int[] {1, 2, 3, 4, 5});
        ListNode result0 = newListNode(new int[] {1, 2, 3, 5});
        System.out.println(logListNode(node0));
        System.out.println(logListNode(result0));
        assertEquals(logListNode(result0), logListNode(solution.removeNthFromEnd(node0, 2)));
    }
    
    private ListNode newListNode(int[] nums)
    {
        ListNode parentNode = new ListNode(0);
        ListNode tempNode = parentNode;
        
        for (int i = 0; i < nums.length; i++)
        {
            tempNode.next = new ListNode(nums[i]);
            tempNode = tempNode.next;
        }
        
        return parentNode.next;
    }
    
    private String logListNode(ListNode node)
    {
        StringBuffer stringBuffer = new StringBuffer();
        while (null != node)
        {
            stringBuffer.append(node.val);
            node = node.next;
        }
        
        return stringBuffer.toString();
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
