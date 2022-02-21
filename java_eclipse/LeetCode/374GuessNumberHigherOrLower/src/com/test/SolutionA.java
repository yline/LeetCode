package com.test;

import com.test.base.Solution;

public class SolutionA extends Solution
{
    @Override
    public int guessNumber(int n)
    {
        int left = 1, right = n;
        
        int value = ((left ^ right) >> 1) + (left & right);
        int result = guess(value);
        while (result != 0)
        {
            if (result == -1) // 值大了
            {
                right = value - 1;
            }
            else
            {
                left = value + 1;
            }
            value = ((left ^ right) >> 1) + (left & right);
            result = guess(value);
        }
        return (int)value;
    }
}
