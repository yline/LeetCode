package com.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.base.Solution;

/**
 * Given a non-empty string s and a dictionary wordDict
 * containing a list of non-empty words,
 * 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * 
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 典型的Tree树，1对多的方案
 * 
 * @author YLine
 *
 * 2019年12月13日 上午10:18:53
 */
public class SolutionA implements Solution
{
    @Override
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        // 入口参数异常
        if (null == s || s.length() == 0)
        {
            return new ArrayList<>();
        }
        
        // 入口参数异常
        if (null == wordDict || wordDict.isEmpty())
        {
            return new ArrayList<>();
        }
        
        List<String> resultList = new ArrayList<>();
        
        CTree root = buildTree(wordDict);
        dfsBreak(root, root, resultList, new ArrayDeque<>(), s, 0);
        
        return resultList;
    }
    
    /**
     * @param queue 存储，空格的位置
     */
    private void dfsBreak(CTree root, CTree tree, List<String> resultList,
        ArrayDeque<Integer> queue, String s, int startIndex)
    {
        // 已经结束了
        if (startIndex == s.length() - 1)
        {
            CTree child = tree.getChild(s.charAt(startIndex));
            if (null != child && child.isEnd)
            {
                // 结束，而且满足条件
                Integer[] spaceArray = new Integer[queue.size()];
                queue.toArray(spaceArray);
                
                StringBuilder sBuilder = new StringBuilder(s);
                for (int spaceIndex = 0; spaceIndex < spaceArray.length; spaceIndex++)
                {
                    sBuilder.insert(spaceArray[spaceIndex].intValue() + spaceIndex + 1, ' ');
                }
                resultList.add(sBuilder.toString());
            }
            return;
        }
        
        // 当前的点的内容
        char val = s.charAt(startIndex);
        
        // 点指向的下一个点
        CTree child = tree.getChild(val);
        if (null == child)
        {
            return;
        }
        
        dfsBreak(root, child, resultList, queue, s, startIndex + 1); // 往下找，表示不插入空格
        
        if (child.isEnd)
        {
            queue.addLast(startIndex); // 加入最后一个
            dfsBreak(root, root, resultList, queue, s, startIndex + 1); // 从root找，表示插入空格
            queue.pollLast(); // 移除最后一个
        }
    }
    
    private static CTree buildTree(List<String> wordDirt)
    {
        CTree root = new CTree('/');
        for (String word : wordDirt)
        {
            CTree temp = root;
            for (int i = 0; i < word.length(); i++)
            {
                temp = temp.addOrFindChild(word.charAt(i));
                if (i == word.length() - 1)
                {
                    temp.isEnd = true; // 最后一个设置为true
                }
            }
        }
        return root;
    }
    
    /**
     * 平台 + 指向平台的点
     * @author YLine
     *
     * 2019年12月13日 上午10:36:42
     */
    private static class CTree
    {
        // 当前平台，包含的内容；以及内容对应的下一个节点内容
        private HashMap<Character, CTree> map;
        
        private char value;
        
        private boolean isEnd; // 是否是结束
        
        public CTree(char val)
        {
            this.value = val;
        }
        
        /**
         * 没有就加入，有就找到
         */
        public CTree addOrFindChild(char val)
        {
            if (null == map)
            {
                map = new HashMap<>();
            }
            
            CTree child = map.get(val);
            if (null == child)
            {
                child = new CTree(val);
                map.put(val, child);
            }
            return child;
        }
        
        public CTree getChild(char val)
        {
            if (null == map)
            {
                return null;
            }
            return map.get(val);
        }
    }
}
