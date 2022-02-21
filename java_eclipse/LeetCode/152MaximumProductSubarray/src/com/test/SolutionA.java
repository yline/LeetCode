package com.test;

import com.test.base.Solution;

/**
 * Given an integer array nums,
 * find the contiguous subarray within an array (containing at least one number) 连续的子序列
 * which has the largest product. 乘积最大的值
 * 
 * 
Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 主要解决：
 * 1，0的问题，可以采用 分割的形式处理掉
 * 2，符号的问题，
 * 
 * @author YLine
 *
 * 2020年5月13日 下午5:55:59
 */
public class SolutionA implements Solution
{
    @Override
    public int maxProduct(int[] nums)
    {
        if (null == nums || nums.length == 0)
        {
            return 0;
        }
        
        if (nums.length == 1)
        {
            return nums[0];
        }
        
        int singleMax = Integer.MIN_VALUE;
        int productMax = Integer.MIN_VALUE;
        
        int left = 0;
        for (int i = 0; i < nums.length; i++)
        {
            singleMax = Math.max(singleMax, nums[i]);
            if (nums[i] == 0)
            {
                if (i > left + 1)
                {
                    productMax = Math.max(productMax, maxProduct(nums, left, i - 1));
                }
                
                left = i + 1;
            }
        }
        
        // 没有0存在，即结束了，也没有计算product, 则结束计算一次
        int endIndex = nums.length - 1;
        if (endIndex > left)
        {
            productMax = Math.max(productMax, maxProduct(nums, left, endIndex));
        }

        return Math.max(singleMax, productMax);
    }
    
    /**
     * 1，长度大于等于 2
     * 2，不需要计算单个的大小
     * 3，内容中没有0，因此，只需要考虑 符号的影响
     * 
     * 00 用动态规划，负数负数取最小值，正数正数取最大值
     * 
     */
    private int maxProduct(int[] nums, int left, int right)
    {
        int result = Integer.MIN_VALUE;
        
        int min = nums[left], max = nums[left];
        for (int i = left + 1; i <= right; i++)
        {
            // 这里是有隐含条件的，乘法之后，绝对值，肯定要大于等于的
            int temp_max = Math.max(min * nums[i], Math.max(max * nums[i], nums[i]));
            min = Math.min(min * nums[i], Math.min(max * nums[i], nums[i]));
            
            max = temp_max;
            result = Math.max(result, max);
        }
        return result;
    }
    
}
