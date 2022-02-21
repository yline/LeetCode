package com.test;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public int findPeakElement(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        return left;
    }
}
