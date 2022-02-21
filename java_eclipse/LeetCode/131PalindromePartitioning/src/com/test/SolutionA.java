package com.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Input: "aab"
 * Output:
 * {
 *      ["aa","b"],
 *      ["a","a","b"]
 * }
 * @author YLine
 *
 * 2019年11月29日 下午3:33:21
 */
public class SolutionA
{
    public List<List<String>> partition(String s)
    {
        if (null == s || s.length() == 0)
        {
            return null;
        }
        
        // key为left，value为right的所有集合，单个表示为[left, right]
        Map<Integer, List<Integer>> cacheMap = new HashMap<>();
        
        // 奇数
        for (int i = 0; i < s.length(); i++)
        {
            int left = i, right = i;
            
            // 不超过边界，并且一直符合条件才添加
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                addPalindromeRecord(cacheMap, left, right);
                left--;
                right++;
            }
        }

        // 偶数
        for (int i = 0; i < s.length(); i++)
        {
            int left = i, right = i + 1;
            
            // 不超过边界，并且一直符合条件才添加
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                addPalindromeRecord(cacheMap, left, right);
                left--;
                right++;
            }
        }

        // 从左到右，依次去找值就是结果了
        List<List<String>> resultList = new ArrayList<>();
        findResult(cacheMap, resultList, new ArrayDeque<>(), s, 0);
        return resultList;
    }
    
    private void findResult(Map<Integer, List<Integer>> cacheMap, List<List<String>> resultList,
        Deque<String> tempQueue, String s, int index)
    {
        if (index == s.length())
        {
            resultList.add(new ArrayList<>(tempQueue));
            return;
        }
        
        List<Integer> nextList = cacheMap.get(index);
        if (null == nextList || nextList.isEmpty())
        {
            return;
        }
        

        for (int i = 0; i < nextList.size(); i++)
        {
            String value = s.substring(index, nextList.get(i) + 1);
            
            tempQueue.addLast(value);
            findResult(cacheMap, resultList, tempQueue, s, nextList.get(i) + 1);
            tempQueue.removeLast();
        }
    }
    
    private void addPalindromeRecord(Map<Integer, List<Integer>> cacheMap, int left, int right)
    {
        List<Integer> cacheList = cacheMap.get(left);
        if (null == cacheList)
        {
            List<Integer> dataList = new ArrayList<>();
            dataList.add(right);
            cacheMap.put(left, dataList);
            return;
        }
        cacheList.add(right);
    }
}
