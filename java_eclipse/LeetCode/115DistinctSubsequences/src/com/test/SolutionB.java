package com.test;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public int numDistinct(String s, String t)
    {
        if (t == null || t.length() == 0)
        {
            return 1;
        }
        
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        int[] count = new int[tArray.length];
        for (int i = 0; i < sArray.length; i++) // s遍历
        {
            //for (int j = 0; j < tArray.length; j++) // t倒序遍历
            for (int j = tArray.length - 1; j >= 0; j--) // t倒序遍历
            {
                if (tArray[j] == sArray[i])
                {
                    if (j == 0)
                    {
                        count[j] += 1;
                    }
                    else
                    {
                        count[j] += count[j - 1];
                    }
                }
            }
        }
        return count[count.length - 1];
    }
}
