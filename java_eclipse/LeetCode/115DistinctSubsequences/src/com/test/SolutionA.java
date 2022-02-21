package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.base.Solution;

/**
 * 1，先转成对应的数组
 * 2，通过递归实现；通过 hashMap 减少重复遍历量
 * 
 * @author YLine
 *
 * 2018年11月30日 上午9:35:03
 */
public class SolutionA implements Solution
{
    @Override
    public int numDistinct(String s, String t)
    {
        if (t.length() > s.length())
        {
            return 0;
        }
        
        // 整理成  二维数组，时间复杂度: n*m
        List<List<Integer>> data = new ArrayList<>(t.length());
        for (int i = 0; i < t.length(); i++)
        {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < s.length(); j++)
            {
                if (t.charAt(i) == s.charAt(j))
                {
                    temp.add(j);
                }
            }
            
            if (temp.isEmpty()) // 某一项数据为零
            {
                return 0;
            }
            else
            {
                data.add(temp);
            }
        }
        
        // 记录初始值
        return dfs(data, 0, -1, new HashMap<>());
    }
    
    /**
     * 求，组成，从小到大排序的，并且长度等于 t.length()的可能性
     * @param data 二维数组
     * @param index 二维数组的当前下标
     * @param lastValue 上一个一维数组选中的值
     */
    private int dfs(List<List<Integer>> data, int index, int lastValue, Map<Integer, Integer> map)
    {
        if (index == data.size())
        {
            return 1;
        }
        
        int result = 0; // 计算每一次的总和
        
        List<Integer> temp = data.get(index);
        for (int j = 0; j < temp.size(); j++)
        {
            if (temp.get(j) > lastValue) // index 和 j 都符合条件
            {
                int key = j * data.size() + index;
                if (map.containsKey(key)) // 储存，以防重复dfs
                {
                    result += map.get(key);
                }
                else
                {
                    int value = dfs(data, index + 1, temp.get(j), map);
                    map.put(key, value);
                    result += value;
                }
            }
        }
        return result;
    }
}
