package com.test;

public class SolutionB {
	public int maxProfit(int[] prices) {

		int tik0 = 0, tik1 = Integer.MIN_VALUE;
		int tik0_old = 0, tik0_pre = 0;

		for (int price : prices) {
			tik0_old = tik0;
			tik0 = Math.max(tik0, tik1 + price);
			tik1 = Math.max(tik1, tik0_pre - price);
			tik0_pre = tik0_old;
		}

		return tik0;

	}
}
