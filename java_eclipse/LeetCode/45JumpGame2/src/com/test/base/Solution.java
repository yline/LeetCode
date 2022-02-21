package com.test.base;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 给一个非负数的整数，你处于开始位置
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 每个元素的大小，代表你最多可以走多少步
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 目标在于使用最少的次数，达到最后一个点
 * 
 * @author YLine
 *
 * 2018年11月28日 上午10:26:53
 */
public interface Solution
{
    public int jump(int[] nums);
}
