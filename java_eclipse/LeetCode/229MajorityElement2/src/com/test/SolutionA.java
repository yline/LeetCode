package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.base.Solution;

/**
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * @author yline
 */
public class SolutionA implements Solution {
	
	public List<Integer> majorityElement(int[] nums) {
		int cap = nums.length / 3;

		HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
		for (int i = 0; i < nums.length; i++) {
			Node value = cache.get(nums[i]);
			if (null == value) {
				cache.put(nums[i], new Node());
			} else {
				value.increase();
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		for (Integer key : cache.keySet()) {
			Node value = cache.get(key);
			if (value.size > cap) {
				result.add(key);
			}
		}

		return result;
	}

	private static class Node {
		private int size;

		private Node() {
			size = 1;
		}

		private void increase() {
			size++;
		}
	}
}
