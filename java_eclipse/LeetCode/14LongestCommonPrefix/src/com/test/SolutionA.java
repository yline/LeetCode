package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    /**
     *   两两匹配，最终找到相同的
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs)
    {
        int length = strs.length;
        
        if (length == 0)
        {
            return "";
        }
        
        while (length > 1)
        {
            for (int i = 0; i < (length + 1) / 2; i++)
            {
                if ((2 * i + 1) >= length)
                {
                    strs[i] = strs[2 * i];
                }
                else
                {
                    strs[i] = getCommonPrefix(strs[2 * i], strs[2 * i + 1]);
                }
            }
            
            length = (length + 1) / 2;
        }
        
        return strs[0];
    }
    
    /**
     *  获取两个字符串，相同的前缀
     * @param s 字符串s
     * @param p 字符串p
     * @return 相同的前缀
     */
    private String getCommonPrefix(String s, String p)
    {
        StringBuffer result = new StringBuffer();
        if (null != s && null != p)
        {
            for (int i = 0; i < s.length(); i++)
            {
                if (i < p.length() && s.charAt(i) == p.charAt(i))
                {
                    result.append(s.charAt(i));
                }
                else
                {
                    break;
                }
            }
        }
        return result.toString();
    }
}
