package com.test.base;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 假设有一个升序的数组，被某一个不确定的点旋转了；
 * （例如[0,1,2,4,5,6,7] 可能成了 [4,5,6,7,0,1,2]）
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 你需要在旋转后的数组中，寻找一个值；若存在，则返回该值的位置，否则返回-1
 * 
 * You may assume no duplicate exists in the array.
 * 数组中，没有重复的值
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 你的算法时间复杂度，必须为，O(log n)
 * 
 * @author YLine
 *
 * 2018年9月18日 下午4:31:25
 */
public interface Solution
{
    int search(int[] nums, int target);
}
