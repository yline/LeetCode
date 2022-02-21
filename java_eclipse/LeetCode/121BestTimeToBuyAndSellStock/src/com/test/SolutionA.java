package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    
    @Override
    public int maxProfit(int[] prices)
    {
        if (null == prices || prices.length < 2)
        {
            return 0;
        }
        
        int profit = 0;
        
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > minValue)
            {
                profit = Math.max(profit, prices[i] - minValue);
            }
            else
            {
                minValue = prices[i];
            }
        }
        
        return profit;
    }
}
