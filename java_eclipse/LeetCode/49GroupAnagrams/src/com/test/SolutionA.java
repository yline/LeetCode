package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.test.base.Solution;

/**
 * 利用HashMap快速计算
 * 
 * @author YLine
 *
 * 2018年11月29日 下午3:30:35
 */
public class SolutionA implements Solution
{
    @Override
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();
        
        HashMap<String, Integer> cacheTypeMap = new HashMap<>();
        for (String content : strs)
        {
            String type = mockHashCode(content);
            if (cacheTypeMap.containsKey(type))
            {
                int index = cacheTypeMap.get(type);
                result.get(index).add(content);
            }
            else
            {
                cacheTypeMap.put(type, result.size());
                
                List<String> data = new ArrayList<>();
                data.add(content);
                result.add(data);
            }
        }
        return result;
    }
    
    /**
     * 由于个人计算独一无二的int值失败，因此，通过排序，计算一个独一无二的string
     * @param str 原始string
     * @return 独一无二的string
     */
    private String mockHashCode(String str)
    {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
