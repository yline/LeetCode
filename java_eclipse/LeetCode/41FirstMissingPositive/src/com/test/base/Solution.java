package com.test.base;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 给定一个，未排序的数组，找出最小的未填入的正数
 * 
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 * 
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 * 
 * @author YLine
 *
 * 2018年11月14日 上午10:57:22
 */
public interface Solution
{
    /**
     * @param nums 数组
     * @return 最小的缺少的正数
     */
    public int firstMissingPositive(int[] nums);
}
