package com.test.base;

/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 给定一个升序的数组，给定一个目标值；如果目标值在数组中，则返回位置；若不在数组中，则返回它将会插入的位置(以升序为条件)
 * 
 * You may assume no duplicates in the array.
 * 可以假设数组中，没有重复的数字
 * 
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 * 
 * @author YLine
 *
 * 2018年9月19日 上午11:19:17
 */
public interface Solution
{
    int searchInsert(int[] nums, int target);
}
