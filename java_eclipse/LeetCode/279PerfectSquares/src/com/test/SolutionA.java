package com.test;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/perfect-squares/
 * 
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
 * 
 * n = (k1)^2 * a1 + (k2)^2 * a2 + (k3)^2 * a3 + ... + (1)^2 * an
 * 
 * @author yline
 *
 */
public class SolutionA {
	private HashMap<Integer, Integer> minMap = new HashMap<Integer, Integer>();

	public int numSquares(int n) {
		minMap.put(0, 0);
		minMap.put(1, 1);
		minMap.put(2, 2);
		minMap.put(3, 3);
		minMap.put(4, 1);

		return dfsFindMinCount(n);
	}

	/**
	 * 对于 n, 找到次数最少的方案
	 * 
	 * @param n 字母
	 * @return 最少的数
	 */
	private int dfsFindMinCount(int n) {
		// 边界条件处理
		if (minMap.containsKey(n)) {
			return minMap.get(n);
		}

		int minResult = n; // 无论如何不可能比n本身还要大
		int maxK = (int) Math.sqrt(n); // 计算出当前最大值所消耗的量
		int maxA = n / (maxK * maxK);

		while (maxA < minResult) {
			int remainN = n - maxA * maxK * maxK; // 剩余量的计算
			minResult = Math.min(minResult, maxA + dfsFindMinCount(remainN)); // 剩余量的最小值 加上 这次的量；对比最小值

			maxK--;
			maxA = n / (maxK * maxK);
		}

		// 缓存一下，并返回值
		minMap.put(n, minResult);
		return minResult;
	}

}
