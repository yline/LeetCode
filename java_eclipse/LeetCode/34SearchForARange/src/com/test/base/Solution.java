package com.test.base;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * 给一个升序的数组，给一个目标值，从数组中找到和目标值相同的一串数字，返回开始位置和结束位置
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 算法的时间复杂度：O(log n)
 * 
 * If the target is not found in the array, return [-1, -1].
 * 如果目标值在数组中不存在，则返回[-1,-1]
 * 
 * @author YLine
 *
 * 2018年9月19日 上午11:02:40
 */
public interface Solution
{
    /**
     * @param nums 数组
     * @param target 目标值
     * @return 开始位置和结束位置
     */
    int[] searchRange(int[] nums, int target);
}
