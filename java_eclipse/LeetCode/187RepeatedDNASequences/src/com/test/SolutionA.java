package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.base.Solution;

/**
 * 36ms
 * @author YLine
 *
 * 2018年12月12日 上午11:01:22
 */
public class SolutionA implements Solution
{
    private static final int LENGTH = 10;
    
    @Override
    public List<String> findRepeatedDnaSequences(String s)
    {
        if (s.length() < LENGTH)
        {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        
        int[] valueArray = value(s);
        HashMap<Integer, Boolean> hashMap = new HashMap<>(); // 值 - 是否已添加过字符串
        for (int i = 0; i < valueArray.length; i++)
        {
            if (hashMap.containsKey(valueArray[i]))
            {
                if (!hashMap.get(valueArray[i]))
                {
                    result.add(s.substring(i, i + LENGTH));
                    hashMap.put(valueArray[i], true);
                }
            }
            else
            {
                hashMap.put(valueArray[i], false);
            }
        }
        
        return result;
    }
    
    /**
     * 在前面的为低位，后面的为高位
     * @param stack
     * @return
     */
    public int[] value(String stack)
    {
        int[] valueArray = new int[stack.length() - LENGTH + 1];
        
        // 计算第一个Value
        for (int i = 0; i < LENGTH; i++)
        {
            valueArray[0] += (charValue(stack.charAt(i)) << (2 * i));
        }
        
        // 依据首个，计算其他的Value
        for (int i = 1; i < valueArray.length; i++)
        {
            valueArray[i] = (valueArray[i - 1] >> 2) + (charValue(stack.charAt(i + LENGTH - 1)) << 18);
        }
        
        return valueArray;
    }
    
    private int charValue(char ch)
    {
        switch (ch)
        {
            case 'A':
                return 0;
            case 'G':
                return 1;
            case 'T':
                return 2;
            case 'C':
                return 3;
            default:
                return 0;
        }
    }
}
