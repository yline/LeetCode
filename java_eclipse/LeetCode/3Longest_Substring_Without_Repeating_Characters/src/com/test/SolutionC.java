package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 解题思路：
 * 1，将第一段"较长的段落"，加入set，并计算出当前最大值
 * 2，往下遍历，若有遇到相同的，则将之前的抛弃掉，从新设置start位置；
 * 
 * 算法复杂度：
 * O(n)
 * 
 * 缺陷：
 * 仅仅允许 ASCⅡ码
 * 
 * @author YLine
 *
 * 2018年7月19日 下午3:26:42
 */
public class SolutionC implements Solution
{
    private final static int EMPTY = -1;
    
    @Override
    public int lengthOfLongestSubstring(String s)
    {
        // 字符串输入不合法
        if (s == null)
        {
            return 0;
        }
        
        // 标记字符是否出现过，并且记录是的最新一次访问的元素的位置
        int[] appear = new int[256];
        Arrays.fill(appear, EMPTY); // 初始化为-1 (0 的长度为1)
        
        int max = 0; // 最大值
        int start = 0; // 当前处理的开始位置
        int lastPosition = 0; // 记录上一次的开始的值
        
        for (int i = 0; i < s.length(); i++) // i为当前最后一位
        {
            lastPosition = appear[s.charAt(i)];
            if (lastPosition == EMPTY) // 没有出现过
            {
                max = Math.max(max, i - start + 1);
            }
            else // 曾经出现过
            {
                // 将跳过的部分，全部填为 -1
                for (int j = start; j <= lastPosition; j++)
                {
                    appear[s.charAt(j)] = EMPTY;
                }
                start = lastPosition + 1;
            }
            
            appear[s.charAt(i)] = i; // 记录出现的字符的最后一个数值
        }
        return max;
    }
}
