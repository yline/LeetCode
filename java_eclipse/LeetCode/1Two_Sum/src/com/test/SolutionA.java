package com.test;

import com.test.base.Solution;

/**
 * 解体思路：
 * 两次循环，循环遍历到结果
 * 
 * 复杂度：
 * n*n/2 ==> O(n*n) 
 * 
 * @author YLine
 *
 * 2018年7月19日 上午11:04:33
 */
public class SolutionA implements Solution
{
    @Override
    public int[] twoSum(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    return new int[] {i, j};
                }
            }
        }
        
        return new int[] {0, 0};
    }
}
