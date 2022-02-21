package com.test;

import java.util.ArrayList;
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
public class SolutionB implements Solution
{
    private static final int[] primeNums =
        {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();
        
        HashMap<Integer, Integer> cacheTypeMap = new HashMap<>();
        for (String content : strs)
        {
            int type = mockHashCode(content);
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
     * 计算出一个 独一无二的 int 值（并且不受顺序影响）
     * @param str 内容
     * @return 独一无二的int值
     */
    private int mockHashCode(String str)
    {
        int result = 1;
        for (int i = 0; i < str.length(); i++)
        {
            result *= primeNums[str.charAt(i) - 'a'];
        }
        return result;
    }
}
