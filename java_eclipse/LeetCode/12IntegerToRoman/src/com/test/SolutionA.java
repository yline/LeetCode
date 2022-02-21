package com.test;

import java.util.Arrays;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    /**
     * 如下符号：Ｉ、Ｖ、Ｘ、Ｌ、Ｃ、Ｄ和Ｍ，分别表示１、５、１０、５０、１００、５００和１０００；
     * @param num
     * @return
     */
    @Override
    public String intToRoman(int num)
    {
        if (num <= 0 || num > 3999)
        {
            return null;
        }
        
        StringBuffer result = new StringBuffer();
        
        int[] array = getIntArray(num);
        
        System.out.println(Arrays.toString(array));
        
        // 千位
        for (int i = 0; i < array[0]; i++)
        {
            result.append("M");
        }
        
        // 百位
        if (9 == array[1])
        {
            result.append("CM");
        }
        else if (array[1] >= 5)
        {
            result.append("D");
            for (int i = 0; i < array[1] - 5; i++)
            {
                result.append("C");
            }
        }
        else if (4 == array[1])
        {
            result.append("CD");
        }
        else
        {
            for (int i = 0; i < array[1]; i++)
            {
                result.append("C");
            }
        }
        
        // 十位
        if (9 == array[2])
        {
            result.append("XC");
        }
        else if (array[2] >= 5)
        {
            result.append("L");
            for (int i = 0; i < array[2] - 5; i++)
            {
                result.append("X");
            }
        }
        else if (4 == array[2])
        {
            result.append("XL");
        }
        else
        {
            for (int i = 0; i < array[2]; i++)
            {
                result.append("X");
            }
        }
        
        // 个位
        if (9 == array[3])
        {
            result.append("IX");
        }
        else if (array[3] >= 5)
        {
            result.append("V");
            for (int i = 0; i < array[3] - 5; i++)
            {
                result.append("I");
            }
        }
        else if (4 == array[3])
        {
            result.append("IV");
        }
        else
        {
            for (int i = 0; i < array[3]; i++)
            {
                result.append("I");
            }
        }
        
        return result.toString();
    }
    
    private int[] getIntArray(int num)
    {
        int[] result = new int[4];
        
        result[0] = num / 1000; // M D
        num %= 1000;
        
        result[1] = num / 100; // C L
        num %= 100;
        
        result[2] = num / 10; // X V
        num %= 10;
        
        result[3] = num % 10; // V I
        
        return result;
    }
}
