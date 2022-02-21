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
        assertEquals(1, solution.shortestSubarray(new int[] {1}, 1));
        assertEquals(-1, solution.shortestSubarray(new int[] {1, 2}, 4));
        assertEquals(3, solution.shortestSubarray(new int[] {2, -1, 2}, 3));
        assertEquals(3, solution.shortestSubarray(new int[] {84, -37, 32, 40, 95}, 167));
        assertEquals(2, solution.shortestSubarray(new int[] {17, 85, 93, -45, -21}, 150));
        assertEquals(3, solution.shortestSubarray(new int[] {-28, 81, -20, 28, -29}, 89));
        assertEquals(1,
            solution.shortestSubarray(new int[] {-45920, 21585, 78217, 56215, 8480, -30307, 85801, -23309, 37466, 14949,
                40753, 41694, 65382, 8738, 69957, -7108, -22199, 8368, -43562, 46592, -49459, 80106, -24014, -39742,
                22839, 31731, 48196, 52866, 97193, -6483, -38614, 17145, 35105, -13875, -921, 89689, 14770, 61496,
                40638, 22856, 70276, 71276, -40474, 38744, -13868, 33468, 35697, 35989, -768, -25394, -41995, 3819,
                -23043, -10697, 60280, 8589, 47763, 9990, 32657, 70436, 66928, 51086, -9603, 55465, -25666, 2250,
                -35683, 19840, 80192, 20598, -12612, -6004, 85768, 90328, -2821, -48599, 35203, -11913, 10164, 3526,
                86466, -15671, -47459, 20271, 51106, 17007, -11406, 60423, 36966, 26891, 55126, 18974, -23178, 52652,
                29681, 31744, -7003, 57481, -30030, -19750},
                87750));
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
