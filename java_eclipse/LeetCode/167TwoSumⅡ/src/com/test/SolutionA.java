package com.test;

import com.test.base.Solution;

/**
 * 解题思路：
 * 1，对排序后的数组，指向两端，总和大于则右边左移，总和小于则左边右移，知道所有数据都处理完
 * 
 * 复杂度：
 * n + O(n*log(n)) + n ==> O(n*log(n))
 * 
 * @author YLine
 *
 * 2018年7月19日 上午11:46:45
 */
public class SolutionA implements Solution
{
    @Override
    public int[] twoSum(int[] nums, int target)
    {
        int i = 0, j = nums.length - 1;
        while (i < j)
        {
            if (nums[i] + nums[j] == target)
            {
                return new int[] {i + 1, j + 1};
            }
            else if (nums[i] + nums[j] > target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        
        return new int[] {0, 0};
    }
}
