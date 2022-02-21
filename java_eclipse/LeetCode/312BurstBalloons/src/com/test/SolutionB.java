package com.test;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public int maxCoins(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        
        int len = nums.length + 2;
        int[] balloons = new int[len];
        balloons[0] = balloons[len - 1] = 1;
        for (int i = 0; i < nums.length; i++)
        {
            balloons[i + 1] = nums[i];
        }
        
        int[][] cache = new int[len][len];
        for (int i = 2; i < len; i++)
        {
            for (int j = 0; j + i < len; j++)
            {
                collectCoins(balloons, j, i + j, cache);
            }
        }
        
        return cache[0][len - 1];
    }
    
    private void collectCoins(int[] balloons, int i, int j, int[][] cache)
    {
        int max = balloons[i] * balloons[j];
        for (int idx = i + 1; idx < j; idx++)
        {
            cache[i][j] = Math.max(cache[i][j], max * balloons[idx] + cache[idx][j] + cache[i][idx]);
        }
    }
}
