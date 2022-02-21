package com.test;

import com.test.base.Solution;

/**
 * 耗时最少
 * 0ms
 * 
 * @author YLine
 *
 * 2019年6月1日 上午7:20:26
 */
public class SolutionB implements Solution
{
    public boolean queryString(String S, int N)
    {
        for (int i = 1; i <= N; i++)
        {
            String bin = Integer.toString(i, 2);
            if (S.indexOf(bin) == -1)
                return false;
        }
        return true;
    }
}
