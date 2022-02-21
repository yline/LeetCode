package com.test.base;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
有一个数组，i个元素位置对应每日的价格day[i]

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
写一个算法，计算最大值；可以假设你可以做任意次数的交易

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
买一次，卖一次

Example 1:
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * @author YLine
 *
 * 2018年12月10日 下午9:07:41
 */
public interface Solution
{
    public int maxProfit(int[] prices);
}
