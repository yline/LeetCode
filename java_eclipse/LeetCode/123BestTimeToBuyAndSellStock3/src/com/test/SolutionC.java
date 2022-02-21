package com.test;

import com.test.base.Solution;

/**
 * 动态规划
 * @author YLine
 *
 * 2018年12月11日 下午6:43:05
 */
public class SolutionC implements Solution
{
    public int maxProfit(int[] prices)
    {
        // f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions. 
        // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
        //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
        // f[0, ii] = 0; 0 times transation makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
        if (prices.length <= 1)
        {
            return 0;
        }
        
        int STEP = 2; // number of max transation allowed
        
        int maxProf = 0;
        int[][] f = new int[STEP + 1][prices.length];
        for (int i = 1; i <= STEP; i++)
        {
            int tmpMax = f[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++)
            {
                f[i][j] = Math.max(f[i][j - 1], prices[j] + tmpMax);
                
                tmpMax = Math.max(tmpMax, f[i - 1][j] - prices[j]);
                maxProf = Math.max(f[i][j], maxProf);
            }
        }
        return maxProf;
    }
}
