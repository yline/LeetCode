package com.test.base;

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
        ListNode node11 = newListNode(1, 3, 5, 7, 9);
        ListNode node12 = newListNode(2, 4, 6, 8, 10);
        ListNode result1 = solution.mergeTwoLists(node11, node12);
        
        logListNode(node11);
        logListNode(node12);
        logListNode(result1);
        
        assertEquals("12345678910", logListNode(result1));
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
