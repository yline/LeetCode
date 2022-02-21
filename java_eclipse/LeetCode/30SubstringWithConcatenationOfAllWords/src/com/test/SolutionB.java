package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.base.Solution;

/**
 * 方案：
 * 暴力遍历，只是增加了 Map做减法（hash值可以鉴别是否相等）
 * 
 * 时间复杂度：
 * n * totalWordsLength
 * 
 * @author YLine
 *
 * 2018年8月30日 下午1:57:31
 */
public class SolutionB implements Solution
{
    public List<Integer> findSubstring(String S, String[] L)
    {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0)
        {
            return res;
        }
        int len = L[0].length(); // length of each word
        
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L)
        {
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }
        
        for (int i = 0; i <= S.length() - len * L.length; i++)
        {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++)
            { // checkc if match
                String str = S.substring(i + j * len, i + j * len + len); // next word
                if (copy.containsKey(str)) // 利用hash值
                { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1)
                    {
                        copy.remove(str);
                    }
                    else
                    {
                        copy.put(str, count - 1);
                    }
                    if (copy.isEmpty())
                    { // matches
                        res.add(i);
                        break;
                    }
                }
                else
                {
                    break; // not in L
                }
            }
        }
        return res;
    }
}
