package com.test;

import com.test.base.Solution;

/**
 * 递归，思路和SolutionA一样，只是简化了
 * @author YLine
 *
 * 2018年12月25日 下午1:20:39
 */
public class SolutionB implements Solution
{
    
    @Override
    public int lastRemaining(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        return 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
}
