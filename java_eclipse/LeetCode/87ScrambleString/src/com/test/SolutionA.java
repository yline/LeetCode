package com.test;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree
 * by partitioning it to two non-empty substrings recursively.
 * 
 * 给一个字符串，可以分割为两个“非空”字符串
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 为了争夺字符串，可以将其中的子字符串，翻转
 * 
 * For example, if we choose the node "gr" and swap its two children,
 * it produces a scrambled string "rgeat".
 * 例如：将gr翻转，得到 rgeat
 * 
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at",
 * it produces a scrambled string "rgtae".
 * 
 * 相似的，可以翻转多个，将great翻转为rgtae
 * 
 * Given two strings s1 and s2 of the same length,
 * determine if s2 is a scrambled string of s1.
 * 给两个字符串，判断他们是否可以通过翻转得到彼此
 * 
 * 翻译：swap the children 的意思是：交换两个子串，并不是翻转
 * 
 * 思路：
 * 递归按照题意拆分
 * 剪枝：利用hash值进行剪枝
 * 
 * @author YLine
 *
 * 2019年6月5日 下午5:57:26
 */
public class SolutionA
{
    public boolean isScramble(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0, s1.length());
    }
    
    private boolean dfs(char[] c1, char[] c2, int left1, int left2, int length)
    {
        // 判断是否相等
        boolean isEqual = true;
        for (int i = 0; i < length; i++)
        {
            if (c1[left1 + i] != c2[left2 + i])
            {
                isEqual = false;
                break;
            }
        }
        
        if (isEqual)
        {
            return true;
        }
        
        // 内容包含不相同
        if (!isContentEqual(c1, c2, left1, left2, length))
        {
            return false;
        }
        
        // 分开两段
        for (int i = 1; i < length; i++)
        {
            boolean headHead = (dfs(c1, c2, left1, left2, i) && dfs(c1, c2, left1 + i, left2 + i, length - i));
            if (headHead || (dfs(c1, c2, left1, left2 + length - i, i) && dfs(c1, c2, left1 + i, left2, length - i)))
            {
                return true;
            }
        }
        
        return false;
    }
    
    private int[] strSize = new int[256];
    
    private boolean isContentEqual(char[] c1, char[] c2, int left1, int left2, int length)
    {
        Arrays.fill(strSize, 0);
        
        for (int i = 0; i < length; i++)
        {
            strSize[c1[left1 + i]]++;
            strSize[c2[left2 + i]]--;
        }
        
        for (int i = 0; i < strSize.length; i++)
        {
            if (strSize[i] != 0)
            {
                return false;
            }
        }
        
        return true;
    }
}
