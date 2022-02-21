package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

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
    
    public void testSolution()
    {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        assertArray(nums, new int[] {1, 2}, solution.twoSum(nums, target));
    }
    
    private void assertArray(int[] nums, int[] expected, int[] result)
    {
        System.out.println("0 expected index = " + expected[0] + ", result = " + result[0]);
        System.out.println("1 expected index = " + expected[1] + ", result = " + result[1]);
        
        System.out.println("0 expected value = " + nums[expected[0]] + ", result = " + nums[result[0]]);
        System.out.println("1 expected value = " + nums[expected[1]] + ", result = " + nums[result[1]]);
        
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
