package com.test.single;

import java.util.Arrays;

/**
 * RK 算法的全称叫 Rabin-Karp 算法
 * 思路：通过hash值，对主串中的(n-m+1)个字符串，计算hash值，然后校对hash值大小
 * 
 * n : 主串长度
 * m : 模式串长度
 * 
 * 简介：利用hash值，计算m的hash值，然后计算n的所有可能值的hash值
 * 1，时间复杂度：最坏 = (n - m) * hash
 * 2，空间负责度：n
 * 3，对hash算法，的要求相对很高，不同场景对应不同的hash算法，很难统一
 * 
 * @author YLine
 *
 * 2019年3月26日 上午10:33:58
 */
public class SolutionRK implements SingleModelSolution
{
    
    @Override
    public int matching(String mainStr, String patternStr)
    {
        // 长度为0，处理
        if (mainStr.length() == 0 && patternStr.length() == 0)
        {
            return 0;
        }
        
        // 长度不合规
        if (patternStr.length() > mainStr.length())
        {
            return ERROR;
        }
        
        // 输入不合规
        if (!checkValid(mainStr) || !checkValid(patternStr))
        {
            return ERROR;
        }
        
        // hash值辅助
        int[] tempArray = new int[patternStr.length()];
        tempArray[0] = 1;
        for (int i = 1; i < tempArray.length; i++)
        {
            tempArray[i] = tempArray[i - 1] * 26;
        }
        
        // 计算出hash值
        int[] hashArray = hash(mainStr, patternStr, tempArray);
        int patternHash = 0;
        for (int i = 0; i < patternStr.length(); i++)
        {
            patternHash += (tempArray[i] * (patternStr.charAt(i) - 'a'));
        }
        System.out.println("hashArray = " + Arrays.toString(hashArray));
        
        // hash值校对，然后字符串校验
        for (int i = 0; i < hashArray.length; i++)
        {
            if (patternHash == hashArray[i] && checkEqual(mainStr, patternStr, i))
            {
                return i;
            }
        }
        
        return ERROR;
    }
    
    private boolean checkValid(String str)
    {
        for (char ch : str.toCharArray())
        {
            if (ch > 'z' || ch < 'a')
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkEqual(String mainStr, String patternStr, int start)
    {
        for (int i = 0; i < patternStr.length(); i++)
        {
            if (patternStr.charAt(i) != mainStr.charAt(start + i))
            {
                return false;
            }
        }
        
        return true;
    }
    
    private int[] hash(String mainStr, String patternStr, int[] tempArray)
    {
        int[] hashArray = new int[mainStr.length() - patternStr.length() + 1];
        Arrays.fill(hashArray, 0);
        
        // 计算第一个
        for (int i = 0; i < patternStr.length(); i++)
        {
            hashArray[0] += (tempArray[i] * (mainStr.charAt(i) - 'a'));
        }
        
        // 从上一个数据中，计算下一个数据
        final int lastIndex = patternStr.length() - 1;
        for (int i = 1; i < hashArray.length; i++)
        {
            int newValue = (tempArray[lastIndex] * (mainStr.charAt(lastIndex + i) - 'a')); // 新增的
            int oldValue = ((hashArray[i - 1] - ((mainStr.charAt(i - 1) - 'a'))) / 26); // 旧数据
            hashArray[i] = newValue + oldValue;
        }
        
        return hashArray;
    }
}
