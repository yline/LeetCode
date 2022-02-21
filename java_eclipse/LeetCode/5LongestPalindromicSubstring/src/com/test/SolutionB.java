package com.test;

import com.test.base.Solution;

/**
 * 解题思路：
 * 1，遍历数组，以每个字符中心向两边扩散，校验回文(分奇偶)
 * 2，逐个比较出最大值
 * 
 * 时间复杂度：
 * n*n
 * 
 * @author YLine
 *
 * 2018年7月23日 下午3:30:51
 */
public class SolutionB implements Solution
{
    /** 官网提供的answer */
    @Override
    public String longestPalindrome(String s)
    {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++)
        {
            // 中心分离
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            // 比较出最大值
            int len = Math.max(len1, len2);
            if (len > end - start)
            {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right)
    {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R))
        {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
