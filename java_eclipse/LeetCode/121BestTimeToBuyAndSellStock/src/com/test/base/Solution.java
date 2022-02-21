package com.test.base;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
假定，你有一个数组，其中第i个元素的价格对应 day[i]

If you were only permitted to complete at most one transaction 
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
假如你被限制做一次交易
例如：买一个以及卖一个，设计一个方法，找出最大利润

Note that you cannot sell a stock before you buy one.
注意：必须买了股票之后，才能售卖


Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

Example 2:
Input: [7,6,4,3,1]
Output: 0

Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * @author YLine
 *
 * 2018年12月10日 下午8:29:27
 */
public interface Solution
{
    public int maxProfit(int[] prices);
}
