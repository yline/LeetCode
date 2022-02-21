package com.test.base;

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
        solution = new SolutionB();
    }
    
    public void testSolution()
    {
        int[] nums2 = new int[] {1, 7, 9, 10};
        int[] nums1 = new int[] {2, 8};
        assertEquals(7.5, solution.findMedianSortedArrays(nums1, nums2));
        
        int[] numA1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numA2 = {2, 4, 6, 8, 10};
        assertEquals(5.5, solution.findMedianSortedArrays(numA1, numA2));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
