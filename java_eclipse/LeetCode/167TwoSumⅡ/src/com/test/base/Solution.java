package com.test.base;

/**
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers 
 * such that they add up to the target, where index1 must be less than index2.
 * 
 * Note:
 *  Your returned answers (both index1 and index2) are not zero-based.
 *  You may assume that each input would have exactly one solution and you may not use the same element twice.
 * 
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 * 给定一个已排序的数组，找出两个数组，之和等于目标结果
 * 最终返回两个数的 位置
 * 
 * Note:
 *  返回值不为0
 *  可以假设，有且仅有一组解
 * 
 * @author YLine
 *
 * 2018年7月19日 上午10:59:01
 */
public interface Solution
{
    int[] twoSum(int[] nums, int target);
}
