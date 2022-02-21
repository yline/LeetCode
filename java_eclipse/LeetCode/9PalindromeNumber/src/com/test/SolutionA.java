package com.test;

import com.test.base.Solution;

/**
 * 解题思路
 * 先转成字符串，然后从中间开始校验是否为回文
 * 
 * 时间复杂度
 * n
 * 
 * Runtime = 99ms
 * 
 * @author YLine
 *
 * 2018年7月24日 下午4:20:58
 */
public class SolutionA implements Solution
{
    @Override
    public boolean isPalindrome(int x)
    {
        String str = String.valueOf(x);
        
        int length = str.length();
        int left = (length - 1) / 2, right = length / 2;
        while (left >= 0)
        {
            if (str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left--;
            right++;
        }
        
        return true;
    }
}
