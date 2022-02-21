package com.test.base;

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
        ListNode node11 = newListNode(1, 3, 5, 7, 9);
        ListNode node12 = newListNode(2, 4, 6, 8, 10);
        ListNode node13 = newListNode(3, 6, 9, 12, 15);
        ListNode node14 = newListNode(4, 8, 12, 16, 20);
        ListNode node15 = newListNode(5, 10, 15, 20, 25);
        
        ListNode result1 = solution.mergeKLists(new ListNode[] {node11, node12, node13, node14, node15});
        
        assertEquals("12334455667889910101212151516202025", logListNode(result1));
        
        ListNode result2 = solution.mergeKLists(new ListNode[] {});
        
        assertEquals("", logListNode(result2));
    }
    
    private ListNode newListNode(int... number)
    {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        
        for (int i = 0; i < number.length; i++)
        {
            temp.next = new ListNode(number[i]);
            temp = temp.next;
        }
        
        return result.next;
    }
    
    private String logListNode(ListNode node)
    {
        StringBuffer stringBuffer = new StringBuffer();
        
        ListNode temp = node;
        
        while (null != temp)
        {
            stringBuffer.append(temp.val + "");
            temp = temp.next;
        }
        
        String result = stringBuffer.toString();
        
        System.out.println(result);
        
        return result;
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
