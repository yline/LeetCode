package com.test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 * 
 * @author yline
 */
public class SolutionA {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> cache = new HashMap();

		for (int i = 0; i < nums.length; i++) {
			Integer value = cache.get(nums[i]);

			if (null == value) {
				cache.put(nums[i], i);
			} else {
				if (i - value <= k) {
					return true;
				} else {
					cache.put(nums[i], i);
				}
			}
		}

		return false;
	}
}
