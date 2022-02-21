package com.test;

/**
 * 判断某个数字，是否能够被解释为一个十进制数字
 * Validate if a given string can be interpreted as a decimal number.
 * 
 * 有以下案例
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * 
 * 为了避免没有描述清楚，你需要考虑一下字符串
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 * However, here is a list of characters that can be in a valid decimal number:
 * 
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * 
 * 思路：
 * 直接按照规则，去写一个规则匹配；
 * 
 * @author YLine
 *
 * 2019年7月1日 上午10:05:10
 */
public class SolutionA
{
    public boolean isNumber(String s)
    {
        // 去掉，首尾的空格
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ')
        {
            start++;
        }
        
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ')
        {
            end--;
        }
        
        // 去掉空格后的字符串，长度要求
        if (end < start)
        {
            return false;
        }
        
        // 校验函数
        boolean isStart = true; // 是否是刚刚开始校验数字【开始和e之后开始】
        boolean isSign = false; // 是否前一个有符号标志【+、-】
        boolean isPoint = false; // 是否具有标点符号
        boolean isNumber = false; // 是否数字已经出现过
        
        boolean isE = false; // e 是否已经出现过
        
        for (int i = start; i <= end; i++)
        {
            char value = s.charAt(i);
            
            // 符号
            if (value == '+' || value == '-')
            {
                if (isStart)
                {
                    if (isSign)
                    {
                        return false;
                    }
                    
                    isSign = true;
                    continue;
                }
                return false;
            }
            
            // 数字
            if (value <= '9' && value >= '0')
            {
                isStart = false;
                isNumber = true;
                continue;
            }
            
            // 标点符号
            if (value == '.')
            {
                if (!isE)
                {
                    if (isPoint)
                    {
                        return false;
                    }
                    
                    isStart = false;
                    isPoint = true;
                    continue;
                }
                return false;
            }
            
            // e
            if (value == 'e')
            {
                if (!isE && isNumber)
                {
                    isStart = true;
                    isE = true;
                    
                    isSign = false;
                    isPoint = false;
                    isNumber = false;
                    continue;
                }
                return false;
            }
            
            return false;
        }
        
        // 默认返回成功
        return !isStart && isNumber;
    }
}
