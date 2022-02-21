package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    private static final char SINGLE = '?';
    
    private static final char MULTIFY = '*';
    
    @Override
    public boolean isMatch(String s, String p)
    {
        int sIndex = 0;
        int pIndex = 0;
        int lastPIndex = -1;
        int lastSIndex = 0;
        while (sIndex < s.length())
        {
            char sChar = s.charAt(sIndex);
            // 长度大于了，若上次有节点，则回到节点；若无节点，则返回false
            char pChar = pIndex < p.length() ? p.charAt(pIndex) : '$';
            
            if (pChar == SINGLE || pChar == sChar)
            {
                sIndex++;
                pIndex++;
            }
            else if (pChar == MULTIFY)
            {
                lastPIndex = pIndex;
                lastSIndex = sIndex;
                pIndex++;
            }
            else if (lastPIndex != -1) // 回到原点
            {
                pIndex = lastPIndex + 1;
                lastSIndex++;
                sIndex = lastSIndex;
            }
            else
            {
                return false;
            }
        }
        
        // 末尾 * 适配
        while (pIndex < p.length() && p.charAt(pIndex) == MULTIFY)
        {
            pIndex++;
        }
        return pIndex == p.length(); // p是否完成
    }
}
