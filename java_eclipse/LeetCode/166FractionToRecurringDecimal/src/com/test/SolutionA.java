package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 给两个整数，代表分子和分母，求结果的string
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 如果除数的小数点是重复的，则用括号包含
 * 
 * 1，负数考虑
 * 2，负数越界考虑
 * 3，整除，为整数的情况
 * 4，整除，有小数点的情况
 * 5，循环，后续才开始的
 * 
 * @author YLine
 *
 * 2019年10月28日 上午10:32:46
 */
public class SolutionA
{
    public String fractionToDecimal(int numerator, int denominator)
    {
        if (numerator == 0)
        {
            return "0";
        }
        
        long newNumerator = numerator;
        if (numerator < 0)
        {
            newNumerator = (numerator == Integer.MIN_VALUE ? 2147483648L : -numerator);
        }
        
        long newDenominator = denominator;
        if (denominator < 0)
        {
            newDenominator = (denominator == Integer.MIN_VALUE ? 2147483648L : -denominator);
        }
        
        if ((numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0))
        {
            return fractionToDecimalInner(newNumerator, newDenominator);
        }
        else
        {
            return "-" + fractionToDecimalInner(newNumerator, newDenominator);
        }
    }
    
    /**
     * .已知，两个值都 >= 0
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimalInner(long numerator, long denominator)
    {
        long integer = numerator / denominator; // 整数部分
        long frac = numerator % denominator; // 小数部分
        
        // 没有小数部分
        if (frac == 0)
        {
            return String.valueOf(integer);
        }
        
        // 有小数部分
        return String.valueOf(integer) + "." + buildFractionalPart(frac, denominator);
    }
    
    /**
     * .已知 frac < deno
     * @param frac 分子
     * @param deno 分母
     * @return
     */
    private String buildFractionalPart(long frac, long deno)
    {
        // 保存出现过的frac，作为一个终止条件；key -> 出现过的frac，
        Map<Long, Integer> flagMap = new HashMap<>();
        flagMap.put(frac, 0);
        
        StringBuilder sBuilder = new StringBuilder();
        
        int repeatLength; // 重复的长度
        int index = 0; // 当前frac的下标
        while (true)
        {
            while (true)
            {
                frac *= 10;
                if (frac > deno)
                {
                    break;
                }
                else
                {
                    sBuilder.append('0');
                    index++;
                }
            }
            
            int nextInt = (int)(frac / deno);
            frac = frac % deno;
            index++;
            
            sBuilder.append(nextInt);
            
            // 出现重复的内容了
            Integer lastValue = flagMap.get(frac);
            if (null != lastValue)
            {
                repeatLength = index - lastValue;
                break;
            }
            flagMap.put(frac, index);
            
            // 除法结束
            if (frac == 0)
            {
                repeatLength = 0;
                break;
            }
        }
        
        // 添加括号
        if (repeatLength != 0)
        {
            sBuilder.insert(sBuilder.length() - repeatLength, '(');
            sBuilder.insert(sBuilder.length(), ')');
            return sBuilder.toString();
        }
        else
        {
            return sBuilder.toString();
        }
    }
}
