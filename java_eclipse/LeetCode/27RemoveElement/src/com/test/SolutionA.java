package com.test;

import java.util.Arrays;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public int removeElement(int[] nums, int val)
    {
        if (null == nums || nums.length == 0)
        {
            return 0;
        }
        
        int left = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (val != nums[i])
            {
                nums[left] = nums[i];
                
                left++;
            }
        }
        
        System.out.println(Arrays.toString(nums));
        
        return left;
    }
}
