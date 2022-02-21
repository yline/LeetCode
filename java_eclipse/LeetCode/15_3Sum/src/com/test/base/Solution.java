package com.test.base;

import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero
 * 
 * Note:
 *  The solution set must not contain duplicate triplets.
 * 
 * Example:
 *  Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * 
 * @author YLine
 * 2017年1月12日 下午9:01:36
 */
public interface Solution
{
    public List<List<Integer>> threeSum(int[] nums);
}
