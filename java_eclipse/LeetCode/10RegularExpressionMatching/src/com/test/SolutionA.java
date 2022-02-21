package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 递推方案，通过测试；
 * 大致思路：
 * 从后往前递推；
 * 
 * 
 * 
 * 测试耗时：13ms【无filter过程】
 * 
 * @author YLine
 *
 * 2018年11月19日 上午10:40:32
 */
public class SolutionA implements Solution
{
    private static final char SINGLE = '.';
    
    private static final char MULTIPLY = '*';
    
    @Override
    public boolean isMatch(String s, String p)
    {
        p = filter(p);
        
        boolean[] match = new boolean[s.length() + 1];
        Arrays.fill(match, false);
        match[s.length()] = true;
        
        // 从末尾开始遍历
        for (int i = p.length() - 1; i >= 0; i--)
        {
            if (p.charAt(i) == MULTIPLY) // 若为'*',则校验是否与前一个匹配
            {
                for (int j = s.length() - 1; j >= 0; j--)
                {
                    match[j] =
                        match[j] || match[j + 1] && (p.charAt(i - 1) == SINGLE || s.charAt(j) == p.charAt(i - 1));
                }
                i--; // 直接跳过，*前一个
            }
            else // 若不为'*'，则校验是否与当前匹配
            {
                for (int j = 0; j < s.length(); j++)
                {
                    match[j] = match[j + 1] && (p.charAt(i) == SINGLE || p.charAt(i) == s.charAt(j));
                }
                
                match[s.length()] = false;
            }
        }
        return match[0];
    }
    
    private String filter(String p)
    {
        StringBuilder pBuilder = new StringBuilder();
        for (int i = 0; i < p.length(); i++)
        {
            if (i == 0 && MULTIPLY == p.charAt(i)) // 开局就是 * 号过滤
            {
                continue;
            }
            
            if (MULTIPLY == p.charAt(i) && MULTIPLY == p.charAt(i - 1)) // 连续的 * 过滤
            {
                continue;
            }
            
            pBuilder.append(p.charAt(i));
        }
        return pBuilder.toString();
    }
}
