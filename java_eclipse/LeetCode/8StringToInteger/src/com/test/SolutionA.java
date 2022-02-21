package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * 思路：
 * 按照条件逐个实现
 * 
 * 时间复杂度：
 * n
 * 
 * @author YLine
 *
 * 2018年7月24日 下午1:40:49
 */
public class SolutionA implements Solution
{
    @Override
    public int myAtoi(String str)
    {
        if (null == str || "".equals(str))
        {
            return 0;
        }
        
        List<Integer> numList = new ArrayList<>();
        char symbol;
        boolean isStart = false, isPositive = true;
        for (int i = 0; i < str.length(); i++)
        {
            symbol = str.charAt(i);
            if (isStart)
            {
                // 如果开始是正常的，则采用已记录的数据
                if (symbol >= '0' && symbol <= '9')
                {
                    numList.add(symbol - '0');
                }
                else
                {
                    break;
                }
            }
            else
            {
                // 首次开始
                if (' ' == symbol)
                {
                    continue;
                }
                
                if ('-' == symbol)
                {
                    isPositive = false;
                    isStart = true;
                    continue;
                }
                
                if ('+' == symbol)
                {
                    isPositive = true;
                    isStart = true;
                    continue;
                }
                
                if (symbol >= '0' && symbol <= '9')
                {
                    numList.add(symbol - '0');
                    isStart = true;
                    continue;
                }
                
                return 0;
            }
        }
        
        System.out.println("numList = " + numList.toString());
        
        // 超长的先排除，避免下个循环大量计算
        int length = numList.size();
        for (int i = 0; i < numList.size(); i++)
        {
            if (numList.get(i) == 0)
            {
                length--;
            }
            else
            {
                break;
            }
        }
        
        if (length >= 12)
        {
            return (isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        }
        
        long result = 0, multiply = 1;
        for (int i = numList.size() - 1; i >= 0; i--)
        {
            result += (numList.get(i) * multiply);
            multiply *= 10;
            
            if (isPositive)
            {
                if (result >= Integer.MAX_VALUE)
                {
                    return Integer.MAX_VALUE;
                }
            }
            else
            {
                if (-result <= Integer.MIN_VALUE)
                {
                    return Integer.MIN_VALUE;
                }
            }
        }
        
        return (int)(isPositive ? result : -result);
    }
}
