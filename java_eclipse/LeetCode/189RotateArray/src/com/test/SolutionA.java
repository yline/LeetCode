package com.test;

/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * @author yline
 */
public class SolutionA {
	public void rotate(int[] nums, int k) {
		// 这种情况就不用操作了
		if (null == nums || nums.length < 2) {
			return;
		}

		// 方案为，逐个递推过去，但是可能会出现循环。因此，只需要找到循环结束点就可以了
		int next = moveAndFoundNext(nums, k, 0);

		// 这里就是所有可能的循环个数
		for (int i = 1; i < next; i++) {
			move(nums, k, i);
		}
	}

	private int moveAndFoundNext(int[] nums, int k, int startIndex) {
		int next = nums.length;
		int nextIndex = (startIndex + k) % nums.length;

		int saveValue = nums[startIndex];
		while (startIndex != nextIndex) {
			int temp = nums[nextIndex];
			nums[nextIndex] = saveValue;
			saveValue = temp;

			next = Math.min(next, nextIndex);
			nextIndex = (nextIndex + k) % nums.length;
		}

		nums[startIndex] = saveValue;

		return next;
	}

	private void move(int[] nums, int k, int startIndex) {
		int nextIndex = (startIndex + k) % nums.length;

		int saveValue = nums[startIndex];
		while (startIndex != nextIndex) {
			int temp = nums[nextIndex];
			nums[nextIndex] = saveValue;
			saveValue = temp;

			nextIndex = (nextIndex + k) % nums.length;
		}

		nums[startIndex] = saveValue;
	}
}
