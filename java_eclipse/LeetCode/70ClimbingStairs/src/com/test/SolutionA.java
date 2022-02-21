package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    
    @Override
    public int climbStairs(int n)
    {
        return dfs(n);
    }
    
    private int dfs(int n)
    {
        if (n < 4) // 其实就是，1、2、3
        {
            return n;
        }
        
        return (dfs(n - 2) << 1) + dfs(n - 3);
    }
}
