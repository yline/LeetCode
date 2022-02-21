package com.test;

import com.test.base.Solution;

/**
 * 这个方法，就是逐个减少
 * 
 * @author YLine
 *
 * 2017年2月4日 下午11:53:36
 */
public class SolutionA implements Solution
{
    /**
     * Divide two integers without using multiplication, division and mod operator.
     * 
     * If it is overflow, return MAX_INT.
     * 
     * @param lDividend
     * @param lDivisor
     * @return
     */
    public int divide(int dividend, int divisor)
    {
        boolean positive;
        
        long lDividend = 0, lDivisor = 0;
        
        // 判断符号
        if (dividend > 0)
        {
            lDividend = Integer.toUnsignedLong(dividend);
            if (divisor > 0)
            {
                positive = true;
                lDivisor = Integer.toUnsignedLong(divisor);
            }
            else
            {
                positive = false;
                lDivisor = Integer.toUnsignedLong(-divisor);
            }
        }
        else
        {
            lDividend = Integer.toUnsignedLong(-dividend);
            if (divisor > 0)
            {
                positive = false;
                lDivisor = Integer.toUnsignedLong(divisor);
            }
            else
            {
                positive = true;
                lDivisor = Integer.toUnsignedLong(-divisor);
            }
        }
        
        // 判断0的条件
        if (lDivisor == 0)
        {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        // 正式计算
        
        // 1,准备数据
        long[] levelBase = new long[32];
        long[] levelNumber = new long[32];
        
        int i = 0;
        long tempBase = 1;
        long tempNumber = lDivisor;
        
        do
        {
            levelBase[i] = tempBase;
            levelNumber[i] = tempNumber;
            
            tempBase += tempBase;
            tempNumber += tempNumber;
            
            i++;
            
        } while (lDividend >= tempNumber);
        
        System.out.println("i = " + i);
        
        // 2,准备结果数组
        long temp = 0, total = 0;
        int count = i; // int[]的 有数长度
        boolean[] levelAble = new boolean[32];
        
        while (temp < lDividend && i > 0)
        {
            total = temp + levelNumber[i - 1];
            if (total < lDividend)
            {
                temp = total;
                levelAble[i - 1] = true;
                i--;
            }
            else if (total == lDividend)
            {
                levelAble[i - 1] = true;
                break;
            }
            else
            {
                i--;
            }
        }
        
        // 计算最终结果
        long result = 0;
        for (int j = 0; j < count; j++)
        {
            if (levelAble[j] == true)
            {
                result += levelBase[j];
            }
        }
        
        // 输出结果,需要先排除边界情况
        if (result > Integer.MAX_VALUE)
        {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        else
        {
            return positive ? (int)result : -(int)result;
        }
    }
    
}
