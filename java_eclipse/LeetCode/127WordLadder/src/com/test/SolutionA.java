package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.base.Solution;

/**
 * 算法复杂度：n*n
 * 耗时 479 ms
 * 
 * @author YLine
 *
 * 2018年12月12日 上午11:01:22
 */
public class SolutionA implements Solution
{
    
    @Override
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        // 生产一份HashMap
        int length = Math.max((int)(wordList.size() / .75f) + 1, 16);
        HashMap<String, Integer> dataMap = new HashMap<>(length);
        for (int i = 0; i < wordList.size(); i++)
        {
            dataMap.put(wordList.get(i), i);
        }
        
        // 没有包含endWord
        if (!dataMap.containsKey(endWord))
        {
            return 0;
        }
        
        int endIndex = dataMap.get(endWord);
        List<List<Integer>> dataList = genChart(beginWord, wordList);
        
        int minLength = 1;
        List<Integer> oldLevelList = dataList.get(0); // 首个
        
        boolean[] visitedArray = new boolean[wordList.size()];
        while (!visitedArray[endIndex]) // 还没有遍历到最后一个
        {
            if (oldLevelList.isEmpty()) // 断层了
            {
                return 0;
            }
            
            List<Integer> tempList = new ArrayList<>(oldLevelList);
            oldLevelList = new ArrayList<>();
            for (int oldIndex : tempList)
            {
                visitedArray[oldIndex] = true;
                for (int nowIndex : dataList.get(oldIndex + 1))
                {
                    if (!visitedArray[nowIndex]) // 还没有添加
                    {
                        oldLevelList.add(nowIndex);
                    }
                }
            }
            
            minLength++;
        }
        
        return minLength;
    }
    
    /**
     * @param beginWord 开始word
     * @param wordList 目标函数
     * @return 长度为 1+wordList.size的数组，第一个为beginWord对应的下一个图；
     */
    private List<List<Integer>> genChart(String beginWord, List<String> wordList)
    {
        // 开始解析【(n-1)*(n-1)】
        boolean[][] matchArray = new boolean[wordList.size()][wordList.size()];
        for (int i = 0; i < wordList.size(); i++)
        {
            for (int j = i; j < wordList.size(); j++)
            {
                matchArray[i][j] = matchArray[j][i] = ((i != j) && 1 == diffWord(wordList.get(i), wordList.get(j)));
            }
        }
        
        // 依据【(n-1)*(n-1)】形成【有向图(n * n-1)】
        List<List<Integer>> matchList = new ArrayList<>(wordList.size() + 1);
        // 首列
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++)
        {
            if (1 == diffWord(beginWord, wordList.get(i)))
            {
                tempList.add(i);
            }
        }
        matchList.add(tempList);
        
        // 其它所有
        for (int i = 0; i < wordList.size(); i++)
        {
            tempList = new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++)
            {
                if (matchArray[i][j])
                {
                    tempList.add(j);
                }
            }
            matchList.add(tempList);
        }
        
        return matchList;
    }
    
    /**
     * 计算两个字符，字符不同的总数
     */
    private int diffWord(String first, String second)
    {
        int diff = 0;
        for (int i = 0; i < first.length(); i++)
        {
            if (first.charAt(i) != second.charAt(i))
            {
                diff++;
            }
        }
        return diff;
    }
}
