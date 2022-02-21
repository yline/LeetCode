package com.test;

import com.test.base.Solution;

/**
 * 解题思路
 * 1，找出数学规律，每一位节点，先计算每个节点的值(其余的位数相乘，求加法)
 * 2，每个节点，进行求余，然后整合出完成的，每个节点范围在(0-9)之间
 * 3，将首位是否为0，判断；然后，拼凑成字符串
 * 
 * 时间复杂度
 * n*n
 * 
 * @author YLine
 *
 * 2018年7月23日 下午4:25:13
 */
public class SolutionA implements Solution
{
    
    @Override
    public String multiply(String num1, String num2)
    {
        if (null == num1 || "".equals(num1) || "0".equals(num1))
        {
            return "0";
        }
        
        if (null == num2 || "".equals(num2) || "0".equals(num2))
        {
            return "0";
        }
        
        int length1 = num1.length(), length2 = num2.length();
        
        // 假设最大长度，计算每一个节点的大小【不做求余操作】
        int[] result = new int[length1 + length2];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = 0;
            // 累加
            for (int j = 0; j <= i; j++)
            {
                if (j < length1 && (i - j) < length2)
                {
                    result[i] += (num1.charAt(length1 - 1 - j) - '0') * (num2.charAt(length2 - 1 - (i - j)) - '0');
                }
            }
        }
        print(result);
        
        // 进行求余操作，由于最多110个字符，因此最大值为110*81 = 8910，最多3位数
        int restNum = 0, totalNum = 0;
        for (int i = 0; i < result.length; i++)
        {
            totalNum = result[i] + restNum;
            result[i] = totalNum % 10; // 个位数
            restNum = totalNum / 10; // 除个位数之外的其他数
        }
        
        // 将Result整合成String
        StringBuilder stringBuilder = new StringBuilder();
        if (result[result.length - 1] != 0)
        {
            stringBuilder.append(result[result.length - 1]);
        }
        
        for (int i = result.length - 2; i >= 0; i--)
        {
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }
    
    private void print(int[] result)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++)
        {
            stringBuilder.append(result[i] + ", ");
        }
        System.out.println(stringBuilder.toString());
    }
}
