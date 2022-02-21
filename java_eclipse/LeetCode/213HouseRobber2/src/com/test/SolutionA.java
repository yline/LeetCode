package com.test;

/**
 * 
 * 递推式
 * result[i] = Math.max(nums[i] + result[i-2], nums[i-1] + result[i-3])
 * 
 * 主要思想：拆开循环，变成两条单独的数组
 * 
 * 优化空间：递推式，其实不需要数组，只需要三个数字就可以了。
 * 
 * @author yline
 *
 */
public class SolutionA {
	public int rob(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private int rob(int[] nums, int start, int end) {
		if (end - start == 1) {
			return Math.max(nums[start], nums[end]);
		}

		if (end - start == 2) {
			return Math.max(nums[start + 1], nums[start] + nums[end]);
		}

		int[] maxArray = new int[end - start + 1];

		maxArray[0] = nums[start];
		maxArray[1] = Math.max(nums[start], nums[start + 1]);
		maxArray[2] = Math.max(nums[start + 1], nums[start] + nums[start + 2]);

		for (int i = 3; i <= end - start; i++) {
			maxArray[i] = Math.max(nums[i + start] + maxArray[i - 2], nums[i + start - 1] + maxArray[i - 3]);
		}

		return Math.max(maxArray[end - start], maxArray[end - start - 1]);
	}
}
