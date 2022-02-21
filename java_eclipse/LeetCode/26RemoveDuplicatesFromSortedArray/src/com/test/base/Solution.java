package com.test.base;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example,
 * Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * 
 * 给定一个 已排序的数组，移除重复的内容
 * 
 * 不允许创建新的队列
 */
public interface Solution
{
    public int removeDuplicates(int[] nums);
}
