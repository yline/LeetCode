package com.test;

import com.test.base.Solution;

public class SolutionB implements Solution {
	public int nthUglyNumber(int n) {

		int[] ans = new int[n];
		int a = 0, b = 0, c = 0;
		ans[0] = 1;

		for (int i = 1; i < n; i++) {

			ans[i] = Math.min(Math.min(2 * ans[a], 3 * ans[b]), 5 * ans[c]);

			if (2 * ans[a] == ans[i]) {
				a++;
			}

			if (3 * ans[b] == ans[i]) {
				b++;
			}

			if (5 * ans[c] == ans[i]) {
				c++;
			}
		}

		return ans[n - 1];
	}
}
