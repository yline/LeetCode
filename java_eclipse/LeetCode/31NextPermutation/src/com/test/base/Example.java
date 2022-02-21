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
    
    /**
     * 测试案例
     */
    public void testSolution()
    {
        System.out.println("字典排序寻找下一个排列，全排列");
        
        assertEqual(new int[] {1, 2, 3}, new int[] {1, 3, 2});
        assertEqual(new int[] {3, 2, 1}, new int[] {1, 2, 3});
        assertEqual(new int[] {1, 1, 5}, new int[] {1, 5, 1});
    }
    
    private void assertEqual(int[] nums, int[] result)
    {
        solution.nextPermutation(nums);
        
        assertEquals(nums.length, result.length);
        for (int i = 0; i < nums.length; i++)
        {
            assertEquals(nums[i], result[i]);
        }
    }
    
    /**
     * 全排列科普
     * 字典法实现 + 递归方式实现
     */
    public void testPermulation()
    {
        Permutation permutation = new Permutation();
        permutation.test();
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
