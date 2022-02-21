package com.test;

import com.test.base.Solution;

/**
 * f(i, j) = f(i-1, j)  如果 s(i) != t(j)
 * f(i, j) = f(i - 1, j - 1) + f(i - 1, j)  如果s(i) == t(j)
 * @author YLine
 * 
 * 2018年12月6日 下午7:06:56
 */
public class SolutionC implements Solution
{
    
    @Override
    public int numDistinct(String s, String t)
    {
        if (null == s || s.isEmpty())
        {
            return 0;
        }
        
        if (null == t || t.isEmpty())
        {
            return 0;
        }
        
        int[][] count = new int[t.length()][s.length()];
        
        // 初始化第一行
        char tFirst = t.charAt(0);
        count[0][0] = tFirst == s.charAt(0) ? 1 : 0;
        
        for (int j = 1; j < s.length(); j++)
        {
            count[0][j] = count[0][j - 1] + (tFirst == s.charAt(j) ? 1 : 0);
        }
        
        // 其他列
        for (int i = 1; i < t.length(); i++)
        {
            for (int j = i; j < s.length(); j++)
            {
                if (t.charAt(i) == s.charAt(j))
                {
                    if (j == i)
                    {
                        count[i][j] = count[i - 1][j - 1] > 0 ? 1 : 0;
                    }
                    else
                    {
                        count[i][j] = count[i][j - 1] + count[i - 1][j - 1];
                    }
                }
                else
                {
                    count[i][j] = count[i][j - 1];
                }
            }
        }
        
        return count[t.length() - 1][s.length() - 1];
    }
}
