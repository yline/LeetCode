package com.test;

/**
 * 
 * For strings S and T, we say "T divides S" if and only
 * if S = T + ... + T  (T concatenated with itself 1 or more times)
 * 
 * S/T = 某个整数
 * 
 * Return the largest string X such that X divides str1 and X divides str2.
 * 求X1、X2的共同值
 * 
 * 可以直接由长度，求的最大公约数，若最大公约数，不满足，则直接返回0
 * 
 * 方案：逐个遍历
 * 
 * 时间复杂度：
 * n*m
 * 
 * @author YLine
 *
 * 2018年8月30日 上午9:27:48
 */
public class SolutionA
{
    public String gcdOfStrings(String str1, String str2)
    {
        int a = str1.length();
        int b = str2.length();
        
        // a > b【求最大公约数】
        int diff;
        if (a == b)
        {
            diff = a;
        }
        else
        {
            if (a < b)
            {
                int temp = a;
                a = b;
                b = temp;
            }
            
            diff = a - b;
            while (diff > 0)
            {
                if (a % diff == 0 && b % diff == 0)
                {
                    break;
                }
                else
                {
                    if (diff > b)
                    {
                        a = diff;
                        diff = a - b;
                    }
                    else
                    {
                        a = b;
                        b = diff;
                        diff = a - b;
                    }
                }
            }
        }
        
        String common = str1.substring(0, diff);
        
        // 如果，最大公约数，不满足，则最大公约数对应的所有子集都不满足，表示，所有都不满足
        // 第一串
        if (!assertCommon(str1, common))
        {
            return "";
        }
        
        // 第二串
        if (!assertCommon(str2, common))
        {
            return "";
        }
        
        return common;
    }
    
    private boolean assertCommon(String main, String pattern)
    {
        if (main.length() % pattern.length() != 0)
        {
            return false;
        }
        else
        {
            int mainIndex = 0;
            int patternIndex = 0;
            while (mainIndex < main.length())
            {
                patternIndex = mainIndex % pattern.length();
                if (main.charAt(mainIndex) != pattern.charAt(patternIndex))
                {
                    return false;
                }
                
                mainIndex++;
            }
        }
        
        return true;
    }
}
