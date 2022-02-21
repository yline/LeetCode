package com.test.base;

/**
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * 给n个非负数的正数，表示一个海拔图，每个高度为1
 * 计算，大水漫溉后，它能容纳多少水
 * 
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 * @author YLine
 *
 * 2018年11月16日 下午4:06:21
 */
public interface Solution
{
    public int trap(int[] height);
}
