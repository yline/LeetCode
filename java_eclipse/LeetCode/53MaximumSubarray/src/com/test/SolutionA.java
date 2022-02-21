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
    public int maxSubArray(int[] nums)
    {
        int max = nums[0], subMax = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            subMax = nums[i] + Math.max(0, subMax);
            max = Math.max(max, subMax);
        }
        return max;
    }
}
