package com.test;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public int maxProduct(int[] nums)
    {
        int product = 1;
        int globalMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++)
        {
            product = product * nums[i];
            globalMax = Math.max(product, globalMax);
            if (nums[i] == 0)
                product = 1;
        }
        
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            product = product * nums[i];
            globalMax = Math.max(product, globalMax);
            if (nums[i] == 0)
                product = 1;
        }
        return globalMax;
    }
}
