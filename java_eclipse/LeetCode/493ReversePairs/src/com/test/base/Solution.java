package com.test.base;

/**
 *  Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * i < j 并且 num[i] > 2*num[j]，就是成功的一对
 * 
 * You need to return the number of important reverse pairs in the given array.
 * 计算给的一个数组，有多少个这样的一对
 * 
 * @author YLine
 *
 * 2019年5月29日 下午1:04:26
 */
public interface Solution
{
    public int reversePairs(int[] nums);
}
