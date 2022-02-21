package com.test;

import com.test.base.Solution;

/**
 * 函数：移动到下一个
 * 
 * 数组、当前的位置、当前已花费的步数
 * f(nums, index, step);
 * 
 * 定义：移动到下移位置;
 * 
 * @author YLine
 *
 * 2018年11月28日 下午12:28:33
 */
public class SolutionA implements Solution
{
    
    @Override
    public int jump(int[] nums)
    {
        if (null == nums || nums.length == 0 || nums.length == 1)
        {
            return 0;
        }
        
        return dfs(nums, 0, 0);
    }
    
    private int dfs(int[] nums, int index, int step)
    {
        if (nums[index] >= nums.length - index - 1)
        {
            return step + 1;
        }
        
        int maxIndex = index + 1;
        int length = index + nums[index] + 1;
        for (int i = index + 2; i < length; i++)
        {
            if (nums[maxIndex] + maxIndex <= nums[i] + i)
            {
                maxIndex = i;
            }
        }
        
        return dfs(nums, maxIndex, step + 1);
    }
}
