package com.test;

import java.util.List;

import com.test.base.Solution;

/**
 * 实际机制为：从底部到顶部，每次比较
 * @author YLine
 *
 * 2018年12月10日 下午8:16:55
 */
public class SolutionB implements Solution
{
    @Override
    public int minimumTotal(List<List<Integer>> triangle)
    {
        int[][] dp = new int[triangle.get(triangle.size() - 1).size()][triangle.size()];
        step(dp, triangle, 0, 0);
        return dp[0][0];
    }
    
    public void step(int[][] dp, List<List<Integer>> t, int p, int h)
    {
        if (dp[p][h] != 0)
        {
            return;
        }
        
        int num = t.get(h).get(p);
        if (h == t.size() - 1)
        {
            dp[p][h] = num;
            return;
        }
        
        step(dp, t, p, h + 1);
        step(dp, t, p + 1, h + 1);
        dp[p][h] = Math.min(num + dp[p][h + 1], num + dp[p + 1][h + 1]);
    }
}
