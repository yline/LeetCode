package com.test;

import com.test.base.Solution;

/**
 * 利用HashMap快速计算
 * 
 * @author YLine
 *
 * 2018年11月29日 下午3:30:35
 */
public class SolutionA implements Solution
{
    
    @Override
    public double myPow(double x, int n)
    {
        return Math.pow(x, n);
    }
}
