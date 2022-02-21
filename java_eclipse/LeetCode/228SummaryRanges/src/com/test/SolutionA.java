package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 * 
 * @author yline
 */
public class SolutionA {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();

		int start = 0;
		while (start < nums.length) {
			start = appendString(result, nums, start);
		}

		return result;
	}

	private int appendString(List<String> result, int[] nums, int start) {
		if (start == nums.length - 1 || nums[start + 1] - nums[start] > 1) {
			result.add(nums[start] + "");
			return start + 1;
		}
		
		for (int i = start; i < nums.length - 1; i++) {
			if (nums[i + 1] - 1 != nums[i]) {
				result.add(nums[start] + "->" + nums[i]);
				return i + 1;
			}
		}
		
		result.add(nums[start] + "->" + nums[nums.length - 1]);
		return nums.length;
	}
}
