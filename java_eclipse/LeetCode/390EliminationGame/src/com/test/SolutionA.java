package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    
    @Override
    public int lastRemaining(int n)
    {
        return find2Right(n);
    }
    
    private int find2Right(int n)
    {
        switch (n)
        {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 2 * find2Left(n / 2);
        }
    }
    
    private int find2Left(int n)
    {
        switch (n)
        {
            case 1:
                return 1;
            case 2:
                return 1;
            default:
                if (n % 2 == 0) // 结尾为偶数
                {
                    return 2 * find2Right(n / 2) - 1;
                }
                else // 结尾为奇数
                {
                    return 2 * find2Right(n / 2);
                }
        }
    }
}
