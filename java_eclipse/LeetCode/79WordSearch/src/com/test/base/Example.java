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
        char[][] boardA = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        
        assertEquals(true, solution.exist(boardA, "ABCCED"));
        assertEquals(true, solution.exist(boardA, "SEE"));
        assertEquals(false, solution.exist(boardA, "ABCB"));
        assertEquals(true, solution.exist(boardA, "ABCESEECFS"));
        
        char[][] boardB = {{'A'}};
        assertEquals(true, solution.exist(boardB, "A"));
        
        char[][] boardC = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        assertEquals(true, solution.exist(boardC, "ABCESEEEFS"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
