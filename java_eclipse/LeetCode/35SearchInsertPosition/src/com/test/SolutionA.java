package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    /**
     * 利用二分法，修改细节校验即可；
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int searchInsert(int[] nums, int target)
    {
        int startIndex = 0, endIndex = nums.length - 1;
        int midIndex;
        
        while (startIndex <= endIndex)
        {
            midIndex = (startIndex + endIndex) >> 1;
            if (target > nums[midIndex])
            {
                if (midIndex == endIndex || target < nums[midIndex + 1])
                {
                    return (midIndex + 1);
                }
                else
                {
                    startIndex = midIndex + 1;
                }
            }
            else if (target < nums[midIndex])
            {
                endIndex = midIndex - 1;
            }
            else
            {
                return midIndex;
            }
        }
        
        return 0;
    }
}
