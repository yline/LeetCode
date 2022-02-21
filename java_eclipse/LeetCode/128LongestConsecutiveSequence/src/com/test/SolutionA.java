package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 给一个未排序的数组，找出最长的连续内容的长度
 * 
 * 要求：
 * Your algorithm should run in O(n) complexity.
 * 时间复杂度为 O(n)
 * 
 * 方案：排序 + 遍历一次，时间复杂度nlog(n) + n
 * 
 * 虽然不合题意，但通过了验收
 * 
 * @author YLine
 *
 * 2019年10月26日 下午6:01:26
 */
public class SolutionA implements Solution
{
    @Override
    public int longestConsecutive(int[] nums)
    {
        if (null == nums || nums.length == 0)
        {
            return 0;
        }
        
        Arrays.sort(nums);
        
        return getLongestOfSort(nums);
    }
    
    private int getLongestOfSort(int[] nums)
    {
        int max = 0;
        
        int temp = 1;
        int preValue = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (preValue + 1 == nums[i])
            {
                temp++;
            }
            else if (preValue == nums[i])
            {
                continue;
            }
            else
            {
                max = Math.max(temp, max);
                temp = 1;
            }
            
            preValue = nums[i];
        }
        
        max = Math.max(temp, max);
        
        return max;
    }
}
