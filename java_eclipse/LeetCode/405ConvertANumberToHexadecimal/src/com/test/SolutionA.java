package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    
    @Override
    public String toHex(int num)
    {
        return Integer.toHexString(num);
    }
}
