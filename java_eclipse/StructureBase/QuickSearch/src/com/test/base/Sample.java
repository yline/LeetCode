package com.test.base;

import com.test.binary.SolutionBiggerFirst;
import com.test.binary.SolutionEqual;
import com.test.binary.SolutionEqualFirst;
import com.test.binary.SolutionEqualLast;
import com.test.binary.SolutionSmallerLast;

import junit.framework.TestCase;

public class Sample extends TestCase
{
    private Solution solution;
    
    private int[] array;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testEqual()
    {
        solution = new SolutionEqual();
        array = new int[] {};
        logSolution(1, -1);
        
        array = new int[] {1};
        logSolution(1, 0);
        
        array = new int[] {0, 1};
        logSolution(1, 1);
        
        array = new int[] {0, 1, 2};
        logSolution(1, 1);
        
        array = new int[] {0, 1, 2, 3, 4, 5};
        logSolution(1, 1);
        
        array = new int[] {0, 1, 3, 431, 432};
        logSolution(1, 1);
        
        array = new int[] {0, 1, 2, 234, 345, 456};
        logSolution(1, 1);
        
        array = new int[] {0, 1, 9, 3};
        logSolution(1, 1);
        
        array = new int[] {0, 2, 9, 3};
        logSolution(1, -1);
    }
    
    public void testEqualFirst()
    {
        solution = new SolutionEqualFirst();
        array = new int[] {};
        logSolution(2, -1);
        
        array = new int[] {2};
        logSolution(2, 0);
        
        array = new int[] {2, 2};
        logSolution(2, 0);
        
        array = new int[] {2, 2, 2};
        logSolution(2, 0);
        
        array = new int[] {0, 2, 2, 2};
        logSolution(2, 1);
        
        array = new int[] {0, 1, 2, 2, 2};
        logSolution(2, 2);
        logSolution(3, -1);
        
        array = new int[] {0, 0, 2, 2, 2};
        logSolution(2, 2);
        
        array = new int[] {0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4};
        logSolution(2, 2);
        
        array = new int[] {1, 1, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9};
        logSolution(2, 2);
    }
    
    public void testEqualLast()
    {
        solution = new SolutionEqualLast();
        array = new int[] {};
        logSolution(2, -1);
        
        array = new int[] {2};
        logSolution(2, 0);
        
        array = new int[] {2, 2};
        logSolution(2, 1);
        
        array = new int[] {2, 2, 2};
        logSolution(2, 2);
        
        array = new int[] {0, 2, 2, 2};
        logSolution(2, 3);
        logSolution(3, -1);
        logSolution(0, 0);
        
        array = new int[] {0, 2, 2, 2, 3};
        logSolution(2, 3);
        logSolution(3, 4);
        logSolution(0, 0);
        logSolution(1, -1);
        
        array = new int[] {0, 1, 2, 2, 2, 4, 5, 5, 5, 6, 7, 8, 8, 8, 8, 9, 9, 9};
        logSolution(0, 0);
        logSolution(1, 1);
        logSolution(2, 4);
        logSolution(3, -1);
        logSolution(4, 5);
        logSolution(5, 8);
        logSolution(6, 9);
        logSolution(7, 10);
        logSolution(8, 14);
        logSolution(9, 17);
        logSolution(10, -1);
    }
    
    public void testBiggerFirst()
    {
        solution = new SolutionBiggerFirst();
        array = new int[] {};
        logSolution(2, -1);
        
        array = new int[] {2};
        logSolution(1, 0);
        logSolution(2, 0);
        logSolution(3, -1);
        
        array = new int[] {2, 2};
        logSolution(1, 0);
        logSolution(2, 0);
        logSolution(3, -1);
        
        array = new int[] {2, 2, 2};
        logSolution(1, 0);
        logSolution(2, 0);
        logSolution(3, -1);
        
        array = new int[] {0, 2, 2, 2};
        logSolution(0, 0);
        logSolution(1, 1);
        logSolution(2, 1);
        logSolution(3, -1);
        
        array = new int[] {0, 2, 2, 2, 3};
        logSolution(0, 0);
        logSolution(1, 1);
        logSolution(2, 1);
        logSolution(3, 4);
        logSolution(4, -1);
        
        array = new int[] {0, 1, 2, 2, 2, 4, 5, 5, 5, 6, 7, 8, 8, 8, 8, 9, 9, 9};
        logSolution(-1, 0);
        logSolution(0, 0);
        logSolution(1, 1);
        logSolution(2, 2);
        logSolution(3, 5);
        logSolution(4, 5);
        logSolution(5, 6);
        logSolution(6, 9);
        logSolution(7, 10);
        logSolution(8, 11);
        logSolution(9, 15);
        logSolution(10, -1);
    }
    
    public void testSmallerLast()
    {
        solution = new SolutionSmallerLast();
        array = new int[] {};
        logSolution(2, -1);
        
        array = new int[] {2};
        logSolution(1, -1);
        logSolution(2, 0);
        logSolution(3, 0);
        
        array = new int[] {2, 2};
        logSolution(1, -1);
        logSolution(2, 1);
        logSolution(3, 1);
        
        array = new int[] {2, 2, 2};
        logSolution(1, -1);
        logSolution(2, 2);
        logSolution(3, 2);
        
        array = new int[] {0, 2, 2, 2};
        logSolution(-1, -1);
        logSolution(0, 0);
        logSolution(1, 0);
        logSolution(2, 3);
        logSolution(3, 3);
        
        array = new int[] {0, 2, 2, 2, 3};
        logSolution(-1, -1);
        logSolution(0, 0);
        logSolution(1, 0);
        logSolution(2, 3);
        logSolution(3, 4);
        logSolution(4, 4);
        
        array = new int[] {0, 1, 2, 2, 2, 4, 5, 5, 5, 6, 7, 8, 8, 8, 8, 9, 9, 9};
        logSolution(-1, -1);
        logSolution(0, 0);
        logSolution(1, 1);
        logSolution(2, 4);
        logSolution(3, 4);
        logSolution(4, 5);
        logSolution(5, 8);
        logSolution(6, 9);
        logSolution(7, 10);
        logSolution(8, 14);
        logSolution(9, 17);
        logSolution(10, 17);
        logSolution(11, 17);
        logSolution(12, 17);
        logSolution(1234, 17);
    }
    
    private void logSolution(int value, int expect)
    {
        assertEquals(expect, solution.bintraySearch(array, value));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
