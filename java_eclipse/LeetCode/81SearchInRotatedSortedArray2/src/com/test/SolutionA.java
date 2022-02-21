package com.test;

import java.util.Arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 提供一个数组，排序之后，以某个点为中心，旋转
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 例如：
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * 给你一个目标值去搜索，如果能找到则返回true，不能则返回false
 * 
 * 1，先找分割点
 * 2，依据分割点，分割开来，二分查找
 * 
 * @author YLine
 *
 * 2019年8月19日 上午10:44:46
 */
public class SolutionA
{
    public boolean search(int[] nums, int target)
    {
        if (null == nums || nums.length == 0)
        {
            return false;
        }
        
        int pivot = 0;
        if (nums[0] != nums[nums.length - 1]) // 分割点不相同
        {
            pivot = findPivot(nums, 0, nums.length - 1);
        }
        else
        {
            int value = nums[0];
            int left = 0;
            for (int i = 1; i < nums.length; i++)
            {
                if (nums[i] != value)
                {
                    left = i;
                    break;
                }
                else if (i == nums.length - 1) // 全等的情况
                {
                    return value == target;
                }
            }
            
            int right = nums.length - 1;
            for (int i = nums.length - 2; i > 0; i--)
            {
                if (nums[i] != value)
                {
                    right = i + 1;
                    break;
                }
            }
            
            pivot = findPivot(nums, left, right);
        }
        
        if (pivot == -1)
        {
            pivot = 0;
        }
        
        System.out.println("nums = " + Arrays.toString(nums) + ", pivot = (" + pivot + "," + nums[pivot] + ")");
        return search(nums, 0, pivot, target) || search(nums, pivot + 1, nums.length - 1, target);
    }
    
    private int findPivot(int[] nums, int start, int end)
    {
        int left = start, right = end;
        while (left <= right)
        {
            int mid = (left + right) >>> 1;
            if ((mid == nums.length - 1) || nums[mid] > nums[mid + 1])
            {
                return mid;
            }
            else if (nums[mid] <= nums[end])
            {
                right = mid - 1;
            }
            else if (nums[mid] >= nums[start])
            {
                left = mid + 1;
            }
        }
        return -1; // 所有的值都相等
    }
    
    private boolean search(int[] nums, int start, int end, int target)
    {
        int left = start, right = end;
        while (left <= right)
        {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target)
            {
                right = mid - 1;
            }
            else if (nums[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
