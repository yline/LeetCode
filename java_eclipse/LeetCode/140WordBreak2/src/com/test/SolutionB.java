package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.test.base.Solution;

/**
 * 虽然 leetcode 通过了，但本机的内存溢出了。。而且是高通过率，所以觉得没啥必要这题
 * Exception
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 
 * 
 * @author YLine
 *
 * 2019年12月25日 上午10:23:13
 */
public class SolutionB implements Solution
{
    int n;
    
    List<String> dp[];
    
    Set<String> set;
    
    boolean visited[];
    
    @Override
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        n = s.length();
        dp = new ArrayList[n];
        visited = new boolean[n];
        set = new HashSet<>();
        
        for (String w : wordDict)
            set.add(w);
        
        return dfs(s, 0, wordDict);
    }
    
    public List<String> dfs(String s, int i, List<String> wordDict)
    {
        if (i == n)
            return new ArrayList();
        
        if (visited[i])
            return dp[i];
        
        dp[i] = new ArrayList<>();
        visited[i] = true;
        String st = s.substring(i);
        
        for (String w : wordDict)
        {
            if (st.startsWith(w))
            {
                List<String> add = dfs(s, i + w.length(), wordDict);
                if (i + w.length() == n)
                {
                    dp[i].add(w);
                }
                else
                {
                    for (String x : add)
                        dp[i].add(w + " " + x);
                }
            }
        }
        return dp[i];
    }
}
