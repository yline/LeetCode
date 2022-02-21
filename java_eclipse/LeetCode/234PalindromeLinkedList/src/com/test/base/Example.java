package com.test.base;

import com.test.SolutionA;
import com.test.SolutionB;

import junit.framework.TestCase;

/**
 * 严重怀疑正确answer
 */
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
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        testSolution();
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        testSolution();
    }
    
    private void testSolution()
    {
        /*ListNode nodeA = buildListNode(1, 2);
        assertEquals(false, solution.isPalindrome(nodeA));*/
        
        ListNode nodeB = buildListNode(1, 2, 2, 1);
        assertEquals(true, solution.isPalindrome(nodeB));
        
        ListNode nodeC = buildListNode(-129, -129);
        assertEquals(true, solution.isPalindrome(nodeC));
        
        ListNode nodeD = buildListNode(1, 2, 3, 4, 5, 6, 7);
        assertEquals(false, solution.isPalindrome(nodeD));
    }
    
    public static ListNode buildListNode(int... array)
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
    
    public static void print(ListNode head)
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
        solution = null;
        super.tearDown();
    }
}
