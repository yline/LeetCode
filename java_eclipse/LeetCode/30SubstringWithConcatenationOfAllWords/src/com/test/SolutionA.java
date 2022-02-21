package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * 方案:
 * 暴力遍历，每个位置每次都检查
 * 
 * 时间复杂度：
 * n * totalWordsLength
 * 
 * 测试：
 * 超时
 * 
 * @author YLine
 *
 * 2018年8月30日 下午1:55:31
 */
public class SolutionA implements Solution
{
    public List<Integer> findSubstring(String s, String[] words)
    {
        // 特殊情况判断
        if (null == words || null == s)
        {
            return new ArrayList<>();
        }
        
        // word内容没有
        if (words.length == 0)
        {
            return new ArrayList<>();
        }
        
        // 长度小于
        int totalWordLength = 0;
        for (String string : words)
        {
            totalWordLength += string.length();
        }
        
        if (s.length() < totalWordLength)
        {
            return new ArrayList<>();
        }
        
        // 正常情况
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - totalWordLength; i++)
        {
            if (isRightPosition(s, words, i))
            {
                result.add(i);
            }
        }
        
        System.out.println(result.toString());
        
        return result;
    }
    
    /**
     * 查询  该位置，是否满足所有 words
     * @param stack 原始字符串
     * @param words 等待检查的words数组
     * @param start 位置
     * @return 是否满足
     */
    private boolean isRightPosition(String stack, String[] words, int start)
    {
        List<Integer> tempList = new ArrayList<>();
        int attachWordsLength = 0;
        
        for (int i = 0; i < words.length; i++)
        {
            attachWordsLength = isRightSingle(stack, start, words, tempList);
            if (attachWordsLength != -1)
            {
                start += attachWordsLength;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 单次查询，该位置开启，是否有words内容满足
     * @param stack 原始字符串
     * @param start 开始遍历位置
     * @param words 等待检查的words数组
     * @param expList 排除检查的words数组位置
     * @return 是否满足
     */
    private int isRightSingle(String stack, int start, String[] words, List<Integer> expList)
    {
        for (int i = 0; i < words.length; i++)
        {
            if (expList.contains(i)) // 已经添加过
            {
                continue;
            }
            else
            {
                if (stack.startsWith(words[i], start)) // 有一个已经满足了，即：单次成功
                {
                    expList.add(i);
                    return words[i].length();
                }
            }
        }
        return -1;
    }
}
