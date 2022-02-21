package com.test;

import com.test.base.Solution;

/**
 * 时间复杂度：
 * log n + log n = 2 * log n ==> O(log n)
 * 
 * @author YLine
 *
 * 2018年9月18日 下午4:36:48
 */
public class SolutionA implements Solution
{
    /**
     * 查询目标值
     * 
     * 1，先查询到旋转的点
     * 2，依据目标值，判断左侧还是右侧；然后分段查找
     */
    public int search(int[] nums, int target)
    {
        if (nums.length == 0)
        {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        
        int minIndex = binarySearchIndex(nums);
        if (target >= nums[minIndex] && target <= nums[end])
        {
            return bintarySearch(nums, minIndex, end, target);
        }
        else if (minIndex > 0 && target >= nums[start] && target <= nums[minIndex - 1])
        {
            return bintarySearch(nums, start, minIndex - 1, target);
        }
        
        return -1;
    }
    
    /**
     * 二分法搜索，找到中间点
     * @param array
     * @return 中间点的值
     */
    public int binarySearchIndex(int[] array)
    {
        int start = 0, end = array.length - 1;
        
        int midIndex;
        while (start < end)
        {
            midIndex = (end + start) >> 1;
            if (array[midIndex] > array[midIndex + 1])
            {
                return (midIndex + 1);
            }
            
            // 不是目标值
            if (array[midIndex] > array[start])
            {
                start = midIndex;
            }
            else
            {
                end = midIndex;
            }
        }
        return 0;
    }
    
    /**
     * 二分法搜索
     * @return 搜索到的值 或 -1
     */
    public int bintarySearch(int[] array, int start, int end, int target)
    {
        int min = start, max = end;
        int mid;
        
        while (min <= max)
        {
            mid = (min + max) >> 1;
            
            if (target > array[mid])
            {
                min = mid + 1;
            }
            else if (target < array[mid])
            {
                max = mid - 1;
            }
            else
            {
                return mid;
            }
            
        }
        
        return -1;
    }
}
