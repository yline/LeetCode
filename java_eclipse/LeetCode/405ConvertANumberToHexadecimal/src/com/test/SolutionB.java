package com.test;

import com.test.base.Solution;

/**
 * LeetCode居然表示，这个比系统快一倍。(3ms - 6ms[系统])
 * @author YLine
 *
 * 2018年12月25日 上午11:45:12
 */
public class SolutionB implements Solution
{
    
    @Override
    public String toHex(int num)
    {
        if (num == 0)
        {
            return "0";
        }
        
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String result = "";
        while (num != 0)
        {
            result = map[(num & 15)] + result;
            num >>>= 4;
        }
        return result;
    }
    
}
