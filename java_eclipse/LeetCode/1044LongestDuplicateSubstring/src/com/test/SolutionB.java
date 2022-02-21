package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 思路：类似KMP，只是自己利用内存，记录状态
 * 
 * 时间复杂度：O(n^2) 还是超时
 * 
 * @author YLine
 *
 * 2019年11月21日 下午3:33:19
 */
public class SolutionB implements Solution
{
    
    @Override
    public String longestDupSubstring(String S)
    {
        if (null == S || S.length() == 0)
        {
            return "";
        }
        
        Plugin plugin = new Plugin(S.length());
        for (int i = 1; i < S.length(); i++)
        {
            plugin.move(S, i);
        }
        
        return plugin.getResult(S);
    }
    
    /**
     * 帮助解决上述问题；为了结构清晰，就单独出来
     */
    private static class Plugin
    {
        private int maxNext, maxLength = Integer.MIN_VALUE;
        
        private final int[] next; // 遍历到最后还有值的话
        
        private final int[] length; // 当前指向下一个对应的（长度-1）
        
        private Plugin(int size)
        {
            next = new int[size];
            Arrays.fill(next, Integer.MAX_VALUE);
            
            length = new int[size];
        }
        
        /**
         * 移动到下一个
         * @param end 新添加的内容，对应的内容【0，end)都是遍历的内容
         */
        public void move(String S, int end)
        {
            for (int i = 0; i < end; i++)
            {
                if (next[i] != Integer.MAX_VALUE)
                {
                    // 上次有记录
                    if (S.charAt(i + length[i]) == S.charAt(end)) // 能够延续上次的记录
                    {
                        length[i]++; // next指向的值，不变
                        
                        if (maxLength < length[i])
                        {
                            maxNext = next[i];
                            maxLength = length[i];
                        }
                    }
                    else
                    {
                        // 上次的记录断了
                        next[i] = Integer.MAX_VALUE; // 清空指向的，length理论上也清空，但没必要；因为用不到
                    }
                }
                else
                {
                    // 上次没有记录
                    if (S.charAt(i) == S.charAt(end)) // 值与新增的相等，则记录；否则，直接过
                    {
                        next[i] = end; // 指向相等的值
                        length[i] = 1; // 等于长度
                        
                        if (maxLength < 1)
                        {
                            maxNext = end;
                            maxLength = 1;
                        }
                    }
                }
            }
        }
        
        public String getResult(String S)
        {
            if (maxLength == Integer.MIN_VALUE)
            {
                return "";
            }
            
            return S.substring(maxNext, maxNext + maxLength);
        }
    }
}
