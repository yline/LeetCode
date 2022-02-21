package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public int findPeakElement(int[] nums)
    {
        if (null == nums || nums.length == 0)
        {
            return -1;
        }
        
        if (nums.length == 1)
        {
            return 0;
        }
        
        if (nums.length == 2)
        {
            return nums[0] > nums[1] ? 0 : 1;
        }
        
        if (nums[0] > nums[1])
        {
            return 0;
        }
        
        if (nums[nums.length - 1] > nums[nums.length - 2])
        {
            return nums.length - 1;
        }
        
        for (int i = 1; i < nums.length - 1; i++)
        {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
            {
                return i;
            }
        }
        
        return -1;
    }

}
