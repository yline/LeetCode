package com.test.base;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums being 2.
 * 
 * 给定一个数组和一个值，移除数组中与该值相同的值
 * 
 * 不允许创建额外的数组
 * 节点值不允许修改
 * 
 */
public interface Solution
{
    
    public int removeElement(int[] nums, int val);
}
