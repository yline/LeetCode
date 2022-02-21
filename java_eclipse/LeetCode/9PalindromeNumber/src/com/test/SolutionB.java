package com.test;

import com.test.base.Solution;

/**
 * 解题思路：
 * int类型，直接颠倒是否相等
 * 
 * 时间复杂度：
 * n
 * 
 * @author YLine
 *
 * 2018年7月24日 下午4:23:14
 */
public class SolutionB implements Solution
{
    @Override
    public boolean isPalindrome(int x)
    {
        
        boolean status = false;
        if (x < 0)
            return status;
        
        int temp = x;
        
        int sum = 0;
        while (temp > 0)
        {
            int remainder = temp % 10;
            sum = sum * 10 + remainder;
            temp = temp / 10;
        }
        
        if (sum == x)
        {
            status = true;
        }
        return status;
    }
    
}
