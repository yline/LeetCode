package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 * 
 * @author yline
 *
 */
public class SolutionA {
	public int maxProfit(int[] prices) {
		if (null == prices || prices.length < 2) {
			return 0;
		}

		SoldState[] soldArray = new SoldState[prices.length];	// 下标代表，买的index
		BuyState buyState = new BuyState();
		CoolState coolState = new CoolState();
		
		for (int i = 0; i < soldArray.length; i++) {
			move2Next(prices, soldArray, buyState, coolState, i);
		}
		
		// 从soldArray 中找到最大的值
		int maxProfile = Math.max(buyState.profile, coolState.profile);
		for (int i = 0; i < soldArray.length; i++) {
			maxProfile = Math.max(maxProfile, soldArray[i].profile);
		}

		return maxProfile;
	}

	private void move2Next(int[] prices, SoldState[] soldArray, BuyState buyState, CoolState coolState, int index) {
		// 每次每个状态有两种情况
		// 1，无操作，意味着，所有的原有状态都可以复用下来
		// 2，进行了相应的操作，意味着，新生成的状态，可以原先状态进行对比
		
		// 缓存 cool 的profile
		int cacheCoolProfile = coolState.profile;
		
		// 只能进行 卖的操作
		for (int i = 0; i < index; i++) {
			// 说明 在 i 天时，进行了买的操作; 所以今天可以卖掉，并且进入 cooldown 的状态
			if (null != soldArray[i]) {
				int newProfile = soldArray[i].profile + prices[index] - prices[i];
				coolState.profile = Math.max(coolState.profile, newProfile);
			}
		}
		
		// 只能进行 买的操作, 并且进入 sold 状态
		soldArray[index] = new SoldState();
		soldArray[index].profile = buyState.profile;
		
		// 只能进行 cooldown 的操作, 并且进入 buy 状态
		buyState.profile = Math.max(buyState.profile, cacheCoolProfile);
	}

	// 只能卖的情况，一共有 prices.length 个
	public static class SoldState {
		private int profile = 0; // 当前的利润
	}

	// 只能买的情况，这个时候，谁的利润大，就使用谁
	public static class BuyState {
		private int profile = 0; // 当前的利润
	}
	
	// 冷却时间的情况，这个时候，谁的利润大，就使用谁
	public static class CoolState{
		private int profile = 0; // 当前的利润
	}
}
