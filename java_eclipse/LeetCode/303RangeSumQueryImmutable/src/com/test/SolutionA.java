package com.test;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example:
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1; sumRange(2, 5) -> -1; sumRange(0, 5) -> -3;
 * 
 * Constraints:
 * 
 * You may assume that the array does not change. There are many calls to
 * sumRange function. 0 <= nums.length <= 10^4 -10^5 <= nums[i] <= 10^5 0 <= i
 * <= j < nums.length
 * 
 * @author yline
 *
 */
public class SolutionA {
	private int[] sumArray;

	public SolutionA(int[] nums) {
		if (null == nums || nums.length == 0) {
			sumArray = new int[] {};
			return;
		}

		sumArray = new int[nums.length];
		sumArray[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sumArray[i] = sumArray[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		if (i == 0) {
			return sumArray[j];
		}
		return sumArray[j] - sumArray[i - 1];
	}
}
