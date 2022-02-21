package com.test;

import com.test.base.Solution;

/**
 * 时间复杂度：n
 * 3ms
 * 
 * @author YLine
 *
 * 2018年12月18日 上午10:45:36
 */
public class SolutionB implements Solution
{
    
    @Override
    public boolean canJump(int[] nums)
    {
        int right = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--)
        {
            if (i + nums[i] >= right)
            {
                right = i;
            }
        }
        return right == 0;
    }
}
