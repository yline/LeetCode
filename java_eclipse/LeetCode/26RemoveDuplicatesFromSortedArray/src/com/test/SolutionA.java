package com.test;

import com.test.base.Solution;

/**
 * 记录位置，然后通过位置赋值，最后返回最后一个位置
 * 
 * 时间复杂度：
 * n
 * 
 * @author YLine
 *
 * 2018年8月29日 下午5:18:10
 */
public class SolutionA implements Solution
{
    @Override
    public int removeDuplicates(int[] nums)
    {
        if (nums.length == 0)
        {
            return 0;
        }
        
        int left = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (temp != nums[i])
            {
                temp = nums[i];
                nums[left] = nums[i];
                
                left++;
            }
        }
        
        // System.out.println(Arrays.toString(nums));
        
        return left;
    }
}
