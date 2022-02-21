package com.test;

import java.util.HashSet;
import java.util.Set;

import com.test.base.Solution;

/**
 * 虽然leetcode上时间复杂度为 O(n)
 * 
 * 但特定情况，感觉还不如O(nlogn)
 * 
 * @author YLine
 *
 * 2019年10月26日 下午6:20:55
 */
public class SolutionB implements Solution
{
    
    @Override
    public int longestConsecutive(int[] nums)
    {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums)
        {
            num_set.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num : num_set)
        {
            if (!num_set.contains(num - 1))
            {
                int currentNum = num;
                int currentStreak = 1;
                
                while (num_set.contains(currentNum + 1))
                {
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
    
}
