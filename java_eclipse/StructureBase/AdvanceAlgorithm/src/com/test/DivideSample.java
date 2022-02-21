package com.test;

import com.test.divide.OrderedNumber;

import junit.framework.TestCase;

public class DivideSample extends TestCase
{
    public void testOrderedNumber()
    {
        OrderedNumber solution = new OrderedNumber();
        
        // 测试 merge方法
        solution.testMerge();
        
        // 测试总方法
        assertEquals(0, solution.calculateOrder(new char[] {'1'}));
        assertEquals(1, solution.calculateOrder(new char[] {'1', '2'}));
        assertEquals(3, solution.calculateOrder(new char[] {'1', '2', '3'}));
        assertEquals(6, solution.calculateOrder(new char[] {'1', '2', '3', '4'}));
        assertEquals(10, solution.calculateOrder(new char[] {'1', '2', '3', '4', '5'}));
        assertEquals(15, solution.calculateOrder(new char[] {'1', '2', '3', '4', '5', '6'}));
        assertEquals(21, solution.calculateOrder(new char[] {'1', '2', '3', '4', '5', '6', '7'}));
        assertEquals(12, solution.calculateOrder(new char[] {'1', '3', '5', '2', '4', '6'}));
        assertEquals(4, solution.calculateOrder(new char[] {'1', '3', '4', '2'}));
        assertEquals(4, solution.calculateOrder(new char[] {'1', '3', '4', '2', '0'}));
        assertEquals(4, solution.calculateOrder(new char[] {'1', '3', '5', '2', '0'}));
    }
}
