package com.test;

import com.test.base.Solution;

/**
 * 解题思路：
 * 循环遍历，若未遇到相同，则计算最大值；若遇到相同的，则从下一个开始寻找
 * 
 * 算法复杂度：
 * n * n/2 ==> O(n*n)
 * 
 * @author YLine
 *
 * 2018年7月19日 下午3:01:24
 */
public class SolutionA implements Solution
{
    @Override
    public int lengthOfLongestSubstring(String s)
    {
        int max = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; j < s.length(); j++)
            {
                max = Math.max(max, j + 1 - i);
                if (j == (s.length() - 1))
                {
                    return max; // 退出 两个for循环
                }
                
                if (s.substring(i, j + 1).contains(s.charAt(j + 1) + ""))
                {
                    break; // 退出当前for循环
                }
            }
        }
        return max;
    }
}
