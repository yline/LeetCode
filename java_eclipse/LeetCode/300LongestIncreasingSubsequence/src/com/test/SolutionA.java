package com.test;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing
 * subsequence is [2,3,7,101], therefore the length is 4.
 * 
 * @author yline
 *
 */
public class SolutionA {
	public int lengthOfLIS(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		
		int[] resultArray = new int[nums.length];

		resultArray[0] = 1;
		for (int k = 1; k < nums.length; k++) {
			int temp = 1;
			for (int i = k - 1; i >= 0; i--) {
				if (nums[k] > nums[i]) {
					temp = Math.max(temp, resultArray[i] + 1);
				}
			}
			resultArray[k] = temp;
		}
		
		int max = 1;
		for (int i = 0; i < resultArray.length; i++) {
			max = Math.max(resultArray[i], max);
		}
		return max;
	}
}
