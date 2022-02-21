package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

public class SolutionB implements Solution {
	public List<Integer> majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}

		// 确定数量最多的两个数
		List<Integer> result = new ArrayList<Integer>();
		int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1) {
				count1++;
			} else if (nums[i] == number2) {
				count2++;
			} else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		// 对这两个数，求个数
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
		}

		// 校验 总个数
		if (count1 > len / 3)
			result.add(number1);
		if (count2 > len / 3)
			result.add(number2);
		return result;
	}
}
