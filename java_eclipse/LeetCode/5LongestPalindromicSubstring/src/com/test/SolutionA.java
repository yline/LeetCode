package com.test;

import com.test.base.Solution;

/**
 * 解题思路：
 * 1，逐个取出截取的字符串，校验是否为回文
 * 2，记录下当前回文的最大值，不断进行比较
 * 
 * 时间复杂度：
 * n*n*n
 * 
 * @author YLine
 *
 * 2018年7月20日 下午5:43:29
 */
public class SolutionA implements Solution
{
    @Override
    public String longestPalindrome(String s)
    {
        // 记录的回文左侧、右侧、两边的距离
        int left = 0, right = 0, max = right - left;
        
        for (int i = 0; i < s.length() - max; i++)
        {
            for (int j = i + max; j < s.length(); j++)
            {
                if (isPalindromeString(s, i, j))
                {
                    if (max < (j - i))
                    {
                        left = i;
                        right = j;
                        max = right - left;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
    
    /**
     * 校验某个字符串，是否是 回文
     * @param str 字符串
     * @param start 开始的位置
     * @param end 结束的位置
     * @return true(是回文)
     */
    public boolean isPalindromeString(String str, int start, int end)
    {
        int low = start, high = end;
        while (low < high)
        {
            if (str.charAt(low) == str.charAt(high))
            {
                low++;
                high--;
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
}
