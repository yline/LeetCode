package com.test;

import com.test.base.Solution;

/**
 * 时间复杂度：n
 * 5ms
 * 
 * @author YLine
 *
 * 2018年12月18日 上午10:28:19
 */
public class SolutionA implements Solution
{
    
    @Override
    public boolean canJump(int[] nums)
    {
        if (null == nums || nums.length == 0)
        {
            return true;
        }
        
        int restStep = nums[0];
        if (restStep < 1)
        {
            return (nums.length == 1);
        }
        
        final int length = nums.length - 1;
        for (int i = 1; i < length; i++)
        {
            restStep--;
            restStep = Math.max(restStep, nums[i]);
            
            if (restStep < 1)
            {
                return false;
            }
        }
        return true;
    }
    
}
