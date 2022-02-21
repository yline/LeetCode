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
        char[][] boardA = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.',
            '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.',
                '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.',
                    '.', '.', '.', '.', '.', '.', '.'}};
        assertEquals(3, solution.numRookCaptures(boardA));
        
        char[][] boardB = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, {'.',
            'p', 'p', 'B', 'p', 'p', '.', '.'}, {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'}, {'.', 'p', 'p', 'B', 'p', 'p',
                '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.',
                    '.', '.', '.', '.', '.', '.', '.'}};
        assertEquals(0, solution.numRookCaptures(boardB));
        
        char[][] boardC = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.',
            '.', '.', 'p', '.', '.', '.', '.'}, {'p', 'p', '.', 'R', '.', 'p', 'B', '.'}, {'.', '.', '.', '.', '.', '.',
                '.', '.'}, {'.', '.', '.', 'B', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.',
                    '.', '.', '.', '.', '.', '.', '.'}};
        assertEquals(3, solution.numRookCaptures(boardC));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
