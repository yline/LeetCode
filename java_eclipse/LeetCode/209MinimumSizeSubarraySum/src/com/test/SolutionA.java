package com.test;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum
 * 
 * @author yline
 */
public class SolutionA {
	public int minSubArrayLen(int s, int[] nums) {
		int left = 0, right = 0;

		int sum = 0;
		boolean isMatch = false;
		while (right < nums.length) {
			sum += nums[right];
			right++;

			if (sum >= s) {
				isMatch = true;
				break;
			}
		}

		// 代表没有匹配的内容
		if (!isMatch) {
			return 0;
		}

		int min = right - left;
		while (right < nums.length) {
			if (isMatch) { // 移动左侧
				sum -= nums[left];
				left++;

				if (sum < s) {
					isMatch = false;
				} else {
					min = Math.min(min, right - left);
				}
			} else {
				sum += nums[right];
				right++;

				if (sum >= s) {
					isMatch = true;
				}
			}
		}
		
		if (isMatch) {
			while (left < right) {
				sum -= nums[left];
				left++;
				
				if (sum < s) {
					isMatch = false;
					break;
				} else {
					min = Math.min(min, right - left);
				}
			}
		}

		return min;
	}
}
