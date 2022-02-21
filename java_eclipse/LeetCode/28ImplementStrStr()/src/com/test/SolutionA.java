package com.test;

import com.test.base.Solution;

/**
 * 方案：逐个遍历
 * 
 * 时间复杂度：
 * n*m
 * 
 * @author YLine
 *
 * 2018年8月30日 上午9:27:48
 */
public class SolutionA implements Solution
{
    
    @Override
    public int strStr(String haystack, String needle)
    {
        if (needle.length() == 0)
        {
            return 0;
        }
        
        final int restLength = haystack.length() - needle.length() + 1;
        for (int i = 0; i < restLength; i++)
        {
            for (int j = 0; j < needle.length(); j++)
            {
                if (haystack.charAt(i + j) == needle.charAt(j))
                {
                    if (j == needle.length() - 1)
                    {
                        return i;
                    }
                }
                else
                {
                    break;
                }
            }
        }
        
        return -1;
    }
}
