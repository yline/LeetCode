package com.test;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array. // 没有相等的情况，因此就不需要处理
 * 
 * 方案1：遍历一次，时间复杂度 O(n)
 * 
 * 方案2：二分法，前一个大于后一个即返回后一个
 * 
 * @author YLine
 *
 * 2020年5月14日 上午10:54:09
 */
public class SolutionA
{
    public int findMin(int[] nums)
    {
        if (nums.length == 1)
        {
            return nums[0];
        }
        
        int index = divide(nums, 0, nums.length - 1);
        return nums[index];
    }
    
    private int divide(int[] nums, int left, int right)
    {
        while (left <= right)
        {
            int mid = (left + right) >> 1;
        
            if (mid == left && left + 1 < nums.length)
            {
                return nums[left] > nums[left + 1] ? left + 1 : left;
            }
            
            if (nums[mid] > nums[left] && nums[mid] > nums[right])
            {
                left = mid;
            }
            else
            {
                right = mid;
            }
        }
        
        return left;
    }
}
