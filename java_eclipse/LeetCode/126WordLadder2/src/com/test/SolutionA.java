package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.test.base.Solution;

/**
 * 算法复杂度：n*n
 * LeetCode运行超时
 * 
 * @author YLine
 *
 * 2018年12月12日 上午11:01:22
 */
public class SolutionA implements Solution
{
    
    @Override
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        int index = -1;
        for (int i = 0; i < wordList.size(); i++)
        {
            if (endWord.equals(wordList.get(i)))
            {
                index = i;
                break;
            }
        }
        
        // endWord没有
        if (index == -1)
        {
            return new ArrayList<>();
        }
        
        // 包含了endWord，手动将beginWord加上
        List<String> dataList = new ArrayList<>(wordList.size() + 1);
        dataList.add(beginWord);
        dataList.addAll(wordList);
        
        // 开始解析【n*n】
        int[][] formatArray = new int[dataList.size()][dataList.size()];
        for (int i = 0; i < dataList.size(); i++)
        {
            for (int j = i; j < dataList.size(); j++)
            {
                if (i != j)
                {
                    formatArray[i][j] = formatArray[j][i] = diffWord(dataList.get(i), dataList.get(j));
                }
            }
        }
        
        List<List<String>> resultList = new ArrayList<>();
        List<String> pathList = new ArrayList<>();
        pathList.add(beginWord);
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        
        dfs(resultList, dataList, formatArray, 0, index + 1, pathList, hashMap, 0);
        
        if (resultList.size() > 0)
        {
            int min = resultList.get(0).size();
            for (List<String> tempList : resultList)
            {
                min = Math.min(min, tempList.size());
            }
            
            int finalMin = min;
            resultList.removeIf(new Predicate<List<String>>()
            {
                @Override
                public boolean test(List<String> t)
                {
                    return (t.size() > finalMin);
                }
            });
        }
        
        return resultList;
    }
    
    private boolean dfs(List<List<String>> resultList, List<String> sourceList, int[][] data, int start, int end,
        List<String> pathList, Map<Integer, Integer> hashMap, int level)
    {
        if (start == end) // 到了结果
        {
            resultList.add(new ArrayList<>(pathList));
            return true;
        }
        
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < data[start].length; i++)
        {
            if ((!hashMap.containsKey(i) || level < hashMap.get(i)) && data[start][i] == 1) // 不包含[没有使用过] 或 级别比当前大[上一次dfs]
            {
                hashMap.put(i, level + 1); // 这一个级别所有的内容
                tempList.add(i);
            }
        }
        
        for (Integer index : tempList)
        {
            pathList.add(sourceList.get(index));
            dfs(resultList, sourceList, data, index, end, pathList, hashMap, level + 1);
            pathList.remove(pathList.size() - 1);
        }
        
        return false; // 还没到结果就直接结束的
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
