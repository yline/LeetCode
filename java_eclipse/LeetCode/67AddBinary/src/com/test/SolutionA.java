package com.test;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 给两个二进制字符串，返回他们的和
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 输入的字符串只有0和1
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA
{
    public String addBinary(String a, String b)
    {
        // 长短控制
        if (a.length() < b.length())
        {
            String temp = a;
            a = b;
            b = temp;
        }
        
        // 容量，避免重复扩容
        int capacity = 1 + a.length();
        StringBuilder sBuilder = new StringBuilder(capacity);
        
        // 相加
        boolean isGrow = growUp(a, b, sBuilder);
        for (int i = b.length(); i < a.length(); i++)
        {
            int aIndex = a.length() - 1 - i;
            if (isGrow)
            {
                if (a.charAt(aIndex) == '1')
                {
                    sBuilder.append('0');
                }
                else
                {
                    sBuilder.append('1');
                    isGrow = false;
                }
            }
            else
            {
                sBuilder.append(a.charAt(aIndex));
            }
        }
        
        if (isGrow)
        {
            sBuilder.append('1');
        }
        
        return sBuilder.reverse().toString();
    }
    
    private boolean growUp(String a, String b, StringBuilder sBuilder)
    {
        boolean isGrow = false;
        for (int i = 0; i < b.length(); i++)
        {
            int aIndex = a.length() - 1 - i;
            int bIndex = b.length() - 1 - i;
            
            // 这里貌似可以用除法优化，但还是感觉这种清晰一些
            int value = a.charAt(aIndex) + b.charAt(bIndex) + (isGrow ? 1 : 0);
            switch (value)
            {
                case '0' + '0':
                    sBuilder.append('0');
                    isGrow = false;
                    break;
                case '0' + '1':
                    sBuilder.append('1');
                    isGrow = false;
                    break;
                case '1' + '1':
                    sBuilder.append('0');
                    isGrow = true;
                    break;
                case '1' + '1' + 1:
                    sBuilder.append('1');
                    isGrow = true;
                    break;
            }
        }
        
        return isGrow;
    }
}
