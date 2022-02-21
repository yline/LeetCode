package com.test;

import com.test.base.Solution;

/**
 * 思路，单次遍历
 * 
 * 遍历过的，维持升序，然后，二分查找法，获取结果
 * 
 * 时间复杂度O(n*logn) - O(n*n)
 * 
 * 耗时 336ms
 * 内存，基本没有申请
 * 
 * @author YLine
 *
 * 2019年5月29日 下午1:05:57
 */
public class SolutionB implements Solution
{
    
    @Override
    public int reversePairs(int[] nums)
    {
        if (nums.length < 2)
        {
            return 0;
        }
        
        int result = 0;
        for (int i = 1; i < nums.length; i++)
        {
            result += pairAndSort(nums, i);
        }
        
        return result;
    }
    
    /**
     * 获取匹配数，并且，排序
     * @param nums 数组
     * @param index 在index之前[不包含]，数据是有序的
     * @return
     */
    private int pairAndSort(int[] nums, int index)
    {
        int result = findPair(nums, index);
        sort(nums, index);
        return result;
    }
    
    private int findPair(int[] nums, int index)
    {
        // 全部淘汰【因为超过最大值了】
        if (nums[index] > (Integer.MAX_VALUE >> 1))
        {
            return 0;
        }
        
        // 【小于最小值】
        if (nums[index] < (Integer.MIN_VALUE >> 1))
        {
            return index;
        }
        
        int value = nums[index] << 1;
        // 大于最大值
        if (value >= nums[index - 1])
        {
            return 0;
        }
        
        // 小于等于最小值
        if (value < nums[0])
        {
            return index;
        }
        
        int left = 0, right = index - 1, mid;
        while (left <= right)
        {
            mid = (left + right) >> 1;
            if (value < nums[mid])
            {
                if (mid == 0 || value >= nums[mid - 1])
                {
                    return index - mid;
                }
                else
                {
                    right = mid - 1;
                }
            }
            else
            {
                left = mid + 1;
            }
        }
        
        // 理论上不可能返回-1
        return -1;
    }
    
    private void sort(int[] nums, int index)
    {
        int value = nums[index];
        
        // 大于等于最大值
        if (value >= nums[index - 1])
        {
            return;
        }
        
        // 小于等于最小值
        if (value <= nums[0])
        {
            System.arraycopy(nums, 0, nums, 1, index);
            nums[0] = value;
            return;
        }
        
        // 其它情况
        int left = 0, right = index - 1, mid;
        while (left <= right)
        {
            mid = (left + right) >> 1;
            if (value < nums[mid])
            {
                if (mid == 0)
                {
                    System.arraycopy(nums, 0, nums, 1, index);
                    nums[0] = value;
                    return;
                }
                else if (value >= nums[mid - 1])
                {
                    System.arraycopy(nums, mid, nums, mid + 1, index - mid);
                    nums[mid] = value;
                    return;
                }
                else
                {
                    right = mid - 1;
                }
            }
            else
            {
                left = mid + 1;
            }
        }
    }
}

