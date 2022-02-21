package com.test;

import com.test.base.Solution;

/**
 * 动态规划，按照递归的写法
 * @author YLine
 *
 * 2018年12月6日 上午10:35:58
 */
public class SolutionB implements Solution
{
    
    @Override
    public int climbStairs(int n)
    {
        if (n < 4)
        {
            return n;
        }
        
        return dfs(1, 2, 2, n);
    }
    
    private int dfs(int first, int second, int level, int target)
    {
        if (level == target)
        {
            return second;
        }
        
        return dfs(second, first + second, level + 1, target);
    }
}
