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
        assertSolution();
    }
    
    private void assertSolution()
    {
        solution = new SolutionA();
        assertEquals(true, solution.book(10, 20));
        assertEquals(false, solution.book(15, 25));
        assertEquals(true, solution.book(20, 30));
        
        solution = new SolutionA();
        assertEquals(true, solution.book(47, 50));
        assertEquals(true, solution.book(33, 41));
        assertEquals(false, solution.book(39, 45));
        assertEquals(false, solution.book(33, 42));
        assertEquals(true, solution.book(25, 32));
        assertEquals(false, solution.book(26, 35));
        assertEquals(true, solution.book(19, 25));
        assertEquals(true, solution.book(3, 8));
        assertEquals(true, solution.book(8, 13));
        assertEquals(false, solution.book(18, 27));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
