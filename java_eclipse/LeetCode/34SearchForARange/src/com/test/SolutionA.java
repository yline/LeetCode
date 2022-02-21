package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    /**
     * 1，先使用二分法，查询到相等的值；若没有，则返回-1
     * 2，使用相等的值，找到最左边的值，和最右边的值
     * @param nums 数组
     * @param target 目标值
     * @return 结果
     */
    @Override
    public int[] searchRange(int[] nums, int target)
    {
        if (nums.length == 0)
        {
            return new int[] {-1, -1};
        }
        
        int midIndex = bintraySearch(nums, target);
        if (-1 == midIndex)
        {
            return new int[] {-1, -1};
        }
        else
        {
            int leftMidIndex = searchMidLeftIndex(nums, target, midIndex);
            int rightMidIndex = searchMidRightIndex(nums, target, midIndex);
            
            return new int[] {leftMidIndex, rightMidIndex};
        }
    }
    
    /**
     * 二分法查询，如果有值，则进行两边的分段查询，否则返回{-1，-1}
     * @param nums
     * @param target
     * @return
     */
    public int bintraySearch(int[] nums, int target)
    {
        int start = 0, end = nums.length - 1;
        int mid;
        
        while (start <= end)
        {
            mid = (start + end) >> 1;
            
            if (target > nums[mid])
            {
                start = mid + 1;
            }
            else if (target < nums[mid])
            {
                end = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        
        return -1;
    }
    
    /**
     * 找出左边的值
     * @param nums 数组
     * @param target 目标值
     * @param end 已经大小相等的值(不是-1)
     * @return
     */
    public int searchMidLeftIndex(int[] nums, int target, int end)
    {
        int startIndex = 0, endIndex = end;
        int midIndex = end;
        
        while (startIndex <= endIndex)
        {
            midIndex = (startIndex + endIndex) >> 1;
            
            if (nums[midIndex] == nums[end])
            {
                if (midIndex == 0 || nums[midIndex] > nums[midIndex - 1])
                {
                    return midIndex;
                }
                else
                {
                    endIndex = midIndex - 1;
                }
            }
            else
            {
                startIndex = midIndex + 1;
            }
        }
        return midIndex;
    }
    
    /**
     * 找出右边的值
     * @param nums 数组
     * @param target 目标大小
     * @param startIndex 数组的开始值
     * @return
     */
    public int searchMidRightIndex(int[] nums, int target, int start)
    {
        int startIndex = start, endIndex = nums.length - 1;
        int midIndex = start;
        
        while (startIndex <= endIndex)
        {
            midIndex = (startIndex + endIndex) >> 1;
            
            if (nums[midIndex] == nums[start])
            {
                if ((midIndex == nums.length - 1) || nums[midIndex] < nums[midIndex + 1])
                {
                    return midIndex;
                }
                else
                {
                    startIndex = midIndex + 1;
                }
            }
            else
            {
                endIndex = midIndex - 1;
            }
        }
        return midIndex;
    }
}
