package com.test.base;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. 
 * 
 * 给定整数数组s，从中找出三个数字之和最接近与给定的数字。返回找出的三个数字之和
 * 
 * You may assume that each input would have exactly one solution.
 * 
 *  可以嘉定，输入的字符，一定有一个解
 * 
 * Such as:
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author YLine
 *
 * 2017年1月12日 下午9:01:36
 */
public interface Solution
{
    public int threeSumClosest(int[] nums, int target);
}
