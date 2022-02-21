package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public String countAndSay(int n)
    {
        String lastStr = "1";
        System.out.println("position = 0, str = " + lastStr);
        for (int i = 1; i < n; i++)
        {
            lastStr = next(lastStr);
            System.out.println("position = " + i + ", str = " + lastStr);
        }
        
        return lastStr;
    }
    
    public String next(String lastStr)
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        int countLength = 1;
        char tempChar = lastStr.charAt(0);
        for (int i = 1; i < lastStr.length(); i++)
        {
            if (lastStr.charAt(i) == tempChar) // 如果值相同
            {
                countLength++;
            }
            else // 如果值不同
            {
                // 添加结果
                stringBuilder.append(String.valueOf(countLength));
                stringBuilder.append(tempChar);
                
                // 重置数据
                tempChar = lastStr.charAt(i);
                countLength = 1;
            }
        }
        
        // 添加 最终结果
        stringBuilder.append(String.valueOf(countLength));
        stringBuilder.append(tempChar);
        
        return stringBuilder.toString();
    }
}
