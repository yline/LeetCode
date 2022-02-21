package com.test;

import java.util.HashMap;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1'
 * B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * 给一个数字，判断有几种方案能够拼凑而成
 * 
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * 
 * 个人采用的是：递归+缓存
 * 
 * 可以修改成：动态规划，其实原理相同
 * 
 * @author YLine
 *
 * 2019年9月10日 上午9:37:53
 */
public class SolutionA
{
    public int numDecodings(String s)
    {
        return dfs(new HashMap<>(), s, 0);
    }
    
    private int dfs(HashMap<Integer, Integer> cacheMap, String s, int index)
    {
        if (index == s.length())
        {
            return 1;
        }
        
        if (index == s.length() - 1)
        {
            return s.charAt(index) == '0' ? 0 : 1;
        }
        
        Integer value = cacheMap.get(index);
        if (null != value)
        {
            return value;
        }
        
        // 还有两个及以上
        final char char1 = s.charAt(index);
        final char char2 = s.charAt(index + 1);
        
        if (char1 == '0') // 当前不满足，直接返回0
        {
            cacheMap.put(index, 0);
            return 0;
        }
        else if (char1 > '2') // 3以上开头，表明肯定是单个
        {
            int f1 = dfs(cacheMap, s, index + 1);
            cacheMap.put(index, f1);
            cacheMap.put(index + 1, f1);
            return f1;
        }
        else if (char1 == '1') // 1开头
        {
            if (char2 == '0')
            {
                int f2 = dfs(cacheMap, s, index + 2);
                cacheMap.put(index, f2);
                cacheMap.put(index + 2, f2);
                return f2;
            }
            else
            {
                int f1 = dfs(cacheMap, s, index + 1);
                cacheMap.put(index + 1, f1);
                
                int f2 = dfs(cacheMap, s, index + 2);
                cacheMap.put(index + 2, f2);
                
                int result = f1 + f2;
                cacheMap.put(index, result);
                return result;
            }
        }
        else // 2开头
        {
            if (char2 == '0')
            {
                int f2 = dfs(cacheMap, s, index + 2);
                cacheMap.put(index, f2);
                cacheMap.put(index + 2, f2);
                return f2;
            }
            else if (char2 > '6')
            {
                int f1 = dfs(cacheMap, s, index + 1);
                cacheMap.put(index, f1);
                cacheMap.put(index + 1, f1);
                return f1;
            }
            else
            {
                int f1 = dfs(cacheMap, s, index + 1);
                cacheMap.put(index + 1, f1);
                
                int f2 = dfs(cacheMap, s, index + 2);
                cacheMap.put(index + 2, f2);
                
                int result = f1 + f2;
                cacheMap.put(index, result);
                return result;
            }
        }
    }
}
