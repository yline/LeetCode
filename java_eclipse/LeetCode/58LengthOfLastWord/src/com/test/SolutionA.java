package com.test;

import com.test.base.Solution;

/**
 * log(n)
 * 
 * 典型的二分法；
 * 1，利用最小值，从所有的最大值中，找到比他小，且最近的【二分法】
 * 2，利用最大值，从上一个找到的起点到终点中，找到最小值比他大，且最近的【二分法】
 * 
 * 3，确定跳过的个数，就可以确定长度，然后搬砖就可以了
 * 
 * @author YLine
 *
 * 2019年5月6日 上午9:17:42
 */
public class SolutionA implements Solution
{
    
    @Override
    public int lengthOfLastWord(String s)
    {
        final char EMPTY = ' ';
        
        int endIndex = s.length() - 1;
        while (endIndex >= 0 && s.charAt(endIndex) == EMPTY)
        {
            endIndex--;
        }
        
        int length = 0;
        for (int i = endIndex; i >= 0; i--)
        {
            if (EMPTY != s.charAt(i))
            {
                length++;
            }
            else
            {
                return length;
            }
        }
        
        return length;
    }
}
