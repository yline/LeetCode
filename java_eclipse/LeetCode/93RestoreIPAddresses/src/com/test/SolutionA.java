package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 * 
 * Example:
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * @author YLine
 *
 * 2019年9月16日 上午9:56:32
 */
public class SolutionA
{
    public List<String> restoreIpAddresses(String s)
    {
        List<String> resultList = new ArrayList<>();
        dfs(resultList, new String[4], 0, s, 0);
        return resultList;
    }
    
    private void dfs(List<String> result, String[] cache, int cIndex, String s, int sIndex)
    {
        // 剩余内容长度不合规，直接结束
        if (sIndex > s.length() || 3 * (4 - cIndex) < s.length() - sIndex)
        {
            return;
        }
        
        if (cIndex == cache.length && sIndex == s.length())
        {
            result.add(build(cache));
            return;
        }
        
        move(result, cache, cIndex, s, sIndex, 1);
        move(result, cache, cIndex, s, sIndex, 2);
        move(result, cache, cIndex, s, sIndex, 3);
    }
    
    private void move(List<String> result, String[] cache, int cIndex, String s, int sIndex, int move)
    {
        if (sIndex + move <= s.length())
        {
            // 长度为2
            if (move == 2)
            {
                if (s.charAt(sIndex) != '0')
                {
                    cache[cIndex] = s.substring(sIndex, sIndex + move);
                    dfs(result, cache, cIndex + 1, s, sIndex + move);
                }
                return;
            }
            
            if (move == 3)
            {
                if (s.charAt(sIndex) == '1') // 开头为1的都可以
                {
                    cache[cIndex] = s.substring(sIndex, sIndex + move);
                    dfs(result, cache, cIndex + 1, s, sIndex + move);
                    return;
                }
                
                if (s.charAt(sIndex) == '2') // 开头为2的
                {
                    // 第二个为0-4的都可以
                    char second = s.charAt(sIndex + 1);
                    if (second >= '0' && second <= '4')
                    {
                        cache[cIndex] = s.substring(sIndex, sIndex + move);
                        dfs(result, cache, cIndex + 1, s, sIndex + move);
                        return;
                    }
                    
                    // 第二个为5的，第三个为0-5都可以
                    char third = s.charAt(sIndex + 2);
                    if (second == '5' && third >= '0' && third <= '5')
                    {
                        cache[cIndex] = s.substring(sIndex, sIndex + move);
                        dfs(result, cache, cIndex + 1, s, sIndex + move);
                        return;
                    }
                }
                
                return;
            }
            
            cache[cIndex] = s.substring(sIndex, sIndex + move);
            dfs(result, cache, cIndex + 1, s, sIndex + move);
        }
    }

    /**
     * .将数组，拼凑成结果
     * @param array
     * @return
     */
    private String build(String... array)
    {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++)
        {
            if (i != 0)
            {
                sBuilder.append('.');
            }
            sBuilder.append(array[i]);
        }
        return sBuilder.toString();
    }
}
