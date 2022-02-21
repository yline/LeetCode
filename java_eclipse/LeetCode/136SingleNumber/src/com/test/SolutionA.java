package com.test;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. 时间复杂度O(n)
 * Could you implement it without using extra memory? 空间复杂度O(1)
 * 
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 * 
 * @author YLine
 *
 * 2019年9月16日 下午2:26:12
 */
public class SolutionA
{
    public int singleNumber(int[] nums)
    {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            result ^= nums[i];
        }
        return result;
    }
}
