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
        ListNode node1 = newListNode(1, 2, 3, 4);
        assertEquals("2143", logListNode(solution.reverseKGroup(node1, 2)));
        
        node1 = newListNode(1, 2, 3, 4);
        assertEquals("3214", logListNode(solution.reverseKGroup(node1, 3)));
        
        node1 = newListNode(1, 2, 3, 4);
        assertEquals("1234", logListNode(solution.reverseKGroup(node1, 5)));
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
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
