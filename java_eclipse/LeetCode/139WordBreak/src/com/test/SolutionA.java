package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty string s and a dictionary wordDict
 * containing a list of non-empty words,
 * 
 * determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
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
public class SolutionA
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        // 入口参数异常
        if (null == s || s.length() == 0)
        {
            return false;
        }
        
        // 入口参数异常
        if (null == wordDict || wordDict.isEmpty())
        {
            return false;
        }
        
        CTree root = buildTree(wordDict);
        
        return dfsBreak(root, root, new HashMap<>(s.length()), s, 0);
    }
    
    private boolean dfsBreak(CTree root, CTree tree, Map<Integer, Boolean> cache, String s, int startIndex)
    {
        // 已经结束了
        if (startIndex == s.length() - 1)
        {
            CTree child = tree.getChild(s.charAt(startIndex));
            return null != child && child.isEnd;
        }
        
        // 直接读取缓存
        if (root == tree)
        {
            Boolean cacheResult = cache.get(startIndex);
            if (null != cacheResult)
            {
                return cacheResult;
            }
        }
        
        // 当前的点的内容
        char val = s.charAt(startIndex);
        
        // 点指向的下一个点
        CTree child = tree.getChild(val);
        if (null == child)
        {
            return false;
        }

        boolean nextResult = dfsBreak(root, child, cache, s, startIndex + 1); // 往下找
        if (nextResult)
        {
            return true;
        }
        
        if (child.isEnd)
        {
            boolean rootResult = dfsBreak(root, root, cache, s, startIndex + 1); // 从root找
            cache.put(startIndex + 1, rootResult); // 缓存值
            return rootResult;
        }
                                             
        return false;
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
