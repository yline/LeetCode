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
        
        int lastValue = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > lastValue)
            {
                profit += (prices[i] - lastValue);
                
            }
            
            lastValue = prices[i];
        }
        
        return profit;
    }
}
