package com.test;

import java.util.HashMap;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public String shortestCommonSupersequence(String str1, String str2)
    {
        result = str1 + str2;
        hashMap = new HashMap<>();
        dfs(str1, str2, 0, 0, 0, new char[result.length()]);
        
        return result;
    }
    
    private String result;
    
    private HashMap<Integer, Integer> hashMap;
    
    private void dfs(String str1, String str2, int aIndex, int bIndex, int index, char[] resultArray)
    {
        int count = index + Math.max(str1.length() - aIndex, str2.length() - bIndex);
        // 结果值，大于当前的值，剪枝
        if (count >= result.length())
        {
            return;
        }
        
        // 数组越界，则跳过
        if (aIndex == str1.length() || bIndex == str2.length())
        {
            StringBuilder sBuilder = new StringBuilder(count);
            for (int i = 0; i < index; i++)
            {
                sBuilder.append(resultArray[i]);
            }
            
            for (int i = aIndex; i < str1.length(); i++)
            {
                sBuilder.append(str1.charAt(i));
            }
            
            for (int i = bIndex; i < str2.length(); i++)
            {
                sBuilder.append(str2.charAt(i));
            }
            
            result = sBuilder.toString();
            return;
        }
        
        // 递归
        if (str1.charAt(aIndex) == str2.charAt(bIndex))
        {
            resultArray[index] = str1.charAt(aIndex);
            dfs(str1, str2, aIndex + 1, bIndex + 1, index + 1, resultArray);
        }
        else
        {
            // 避免重复计算
            int value = (aIndex * 1000) + bIndex;
            if (hashMap.containsKey(value) && hashMap.get(value) <= index)
            {
                return;
            }
            else
            {
                hashMap.put(value, index);
            }
            
            // 选择a
            resultArray[index] = str1.charAt(aIndex);
            dfs(str1, str2, aIndex + 1, bIndex, index + 1, resultArray);
            
            // 选择b
            resultArray[index] = str2.charAt(bIndex);
            dfs(str1, str2, aIndex, bIndex + 1, index + 1, resultArray);
        }
    }
}
