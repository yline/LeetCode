package com.test;

import com.test.base.Solution;

/**
 * 感觉这题，没劲
 * 参考：https://www.cnblogs.com/grandyang/p/9406434.html
 * 
 * @author YLine
 *
 * 2019年5月9日 上午8:25:07
 */
public class SolutionA implements Solution
{
    @Override
    public double soupServings(int N)
    {
        double[][] memo = new double[200][200];
        return N >= 4800 ? 1.0 : dfs(memo, (N + 24) / 25, (N + 24) / 25);
    }
    
    private double dfs(double[][] memo, int a, int b)
    {
        if (a <= 0 && b <= 0)
        {
            return 0.5;
        }
        
        if (a <= 0)
        {
            return 1.0;
        }
        
        if (b <= 0)
        {
            return 0;
        }
        
        if (memo[a][b] > 0)
        {
            return memo[a][b];
        }
        
        memo[a][b] = 0.25 * (dfs(memo, a - 4, b) + dfs(memo, a - 3, b - 1)
            + dfs(memo, a - 2, b - 2) + dfs(memo, a - 1, b - 3));
        return memo[a][b];
    }
}
