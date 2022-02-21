package com.test.base;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * 时间复杂度： 1，构建缓存，算n 2，找出最小值，感觉复杂度全部便利了。很高；优化方案：建立一个数组缓存，取最小值
 * 
 * 超时
 * 
 * @author yline
 */
public interface Solution
{
    public int minCut(String s);
}
