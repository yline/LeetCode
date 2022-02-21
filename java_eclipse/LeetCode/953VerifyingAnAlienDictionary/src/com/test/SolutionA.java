package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 * 
 * @author YLine
 *
 * 2019年11月29日 下午4:48:42
 */
public class SolutionA
{
    public boolean isAlienSorted(String[] words, String order)
    {
        if (null == words || words.length < 2)
        {
            return true;
        }
        
        Map<Character, Integer> cacheMap = new HashMap<>();
        initMap(cacheMap, order);
        
        for (int i = 1; i < words.length; i++)
        {
            if (!checkSort(cacheMap, words[i - 1], words[i]))
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkSort(Map<Character, Integer> cacheMap, String pre, String now)
    {
        int max = Math.min(pre.length(), now.length());
        int index = 0;
        while (index < max)
        {
            // 相等
            char preChar = pre.charAt(index);
            char nowChar = now.charAt(index);
            if (preChar == nowChar)
            {
                index++;
                continue;
            }
            
            if (cacheMap.get(preChar) < cacheMap.get(nowChar))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        return pre.length() < now.length();
    }
    
    private void initMap(Map<Character, Integer> cacheMap, String order)
    {
        for (int i = order.length() - 1; i >= 0; i--)
        {
            cacheMap.put(order.charAt(i), i);
        }
    }
}
