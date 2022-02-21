package com.test;

import com.test.base.Solution;

/**
 * 
 * 定义函数：f(s(sIndex), sIndex, p(pIndex), pIndex)为从 index到最后一位的匹配结果
 * 
 * 若index的下一个不是*；则, f(sIndex, pIndex) = (当前相等) && f(sIndex+1, pIndex+1)
 * 若index的下一个是*；则，{
 * 1，当前不相等，则，f(sIndex, pIndex) = f(sIndex, pIndex + 2);
 * 2，当前相等，则，f(sIndex, pIndex) = f(sIndex, pIndex + 2) + (当前相等)&&f(sIndex+1, pIndex + 2) +...+ (当前相等)&&f(sIndex+n, pIndex + 2)
 * 而且，2中只要有一个成功即可，因此可表示为：f(sIndex, pIndex + 2) || (当前相等)&&f(sIndex+1, pIndex)
 * }
 * 
 * 测试耗时：47ms【无filter过程】
 * 
 * @author YLine
 *
 * 2018年11月19日 下午12:58:28
 */
public class SolutionD implements Solution
{
    private static final char SINGLE = '.';
    
    private static final char MULTIPLY = '*';
    
    @Override
    public boolean isMatch(String s, String p)
    {
        String pResult = filter(p);
        return dfs(s, 0, pResult, 0);
    }
    
    private boolean dfs(String s, int sIndex, String p, int pIndex)
    {
        // 边界条件
        if (pIndex == p.length())
        {
            if (sIndex == s.length())
            {
                return true;
            }
            return false;
            
        }
        
        // 若index的下一个不是*；则, f(sIndex, pIndex) = (当前相等) && f(sIndex+1, pIndex+1)
        if (pIndex + 1 == p.length() || MULTIPLY != p.charAt(pIndex + 1))
        {
            
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || SINGLE == p.charAt(pIndex)))
            {
                return dfs(s, sIndex + 1, p, pIndex + 1);
            }
            else
            {
                return false;
            }
        }
        else // 若index的下一个是*
        {
            
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || SINGLE == p.charAt(pIndex)))
            {
                // 2，当前相等，则，f(sIndex, pIndex + 2) || (当前相等)&&f(sIndex+1, pIndex)
                return dfs(s, sIndex, p, pIndex + 2) || dfs(s, sIndex + 1, p, pIndex);
            }
            else
            {
                // 1，当前不相等，则，f(sIndex, pIndex) = f(sIndex, pIndex + 2);
                return dfs(s, sIndex, p, pIndex + 2);
            }
        }
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
