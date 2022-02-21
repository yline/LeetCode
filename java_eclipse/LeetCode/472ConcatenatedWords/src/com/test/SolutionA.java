package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of words (without duplicates),
 * 给一串没有相同字符的字符组
 * please write a program that returns all concatenated words in the given list of words.
 * 实现一个算法，返回列表中完全由其它字符组成的字符
 * 
 * A concatenated word is defined as a string
 * 由其它字符组成的字符含义是
 * that is comprised entirely of at least two shorter words in the given array.
 * 该字符，是列表中其它两个以上(包含两个)的字符，组成
 * 
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Note:
 * The number of elements of the given array will not exceed 10,000
 * The length sum of elements in the given array will not exceed 600,000.
 * All the input string will only include lower case letters.
 * The returned elements order does not matter.
 * 
 * 1，先按字符长短排序，短->长
 * 2，Tree结构整成；一个个的添加(独立的，则加入，否则加入)
 * 
 * Tree树的多模式串，和单一主串，匹配问题
 * 
 * @author YLine
 *
 * 2019年8月12日 下午2:14:23
 */
public class SolutionA
{
    
    public List<String> findAllConcatenatedWordsInADict(String[] words)
    {
        if (words.length < 3)
        {
            return new ArrayList<>();
        }
        
        Arrays.sort(words, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.length() - o2.length();
            }
        });
        
        System.out.println(Arrays.toString(words));
        
        List<String> result = new ArrayList<>();
        NTree root = new NTree();
        addWord(root, words[0]);
        for (int i = 1; i < words.length; i++)
        {
            if (isMatch(root, words[i]))
            {
                result.add(words[i]);
            }
            else
            {
                addWord(root, words[i]);
            }
        }
        
        System.out.println(Arrays.toString(result.toArray()));
        
        return result;
    }
    
    /**
     * .当前字符，是否由其它字符构成
     * @param root 已添加的内容
     * @param words 当前的单词
     * @return 是否满足
     */
    private boolean isMatch(NTree root, String words)
    {
        return isMatch(root, words, root, 0, 0);
    }
    
    /**
     * 
     * @param root 根节点
     * @param words 当前的单词
     * 
     * @param node 当前节点
     * @param index 当前单词的位置
     * @param size 已经包含的单词数量
     * @return
     */
    private boolean isMatch(NTree root, String words, NTree node, int index, int size)
    {
        NTree value = node.getValue(words.charAt(index));
        if (null == value)
        {
            return false;
        }
        
        // 遍历到最后一个节点
        if (index == words.length() - 1)
        {
            // 当最后一个字母时，要求当前节点也是其他单词的结束，并且已经有其他单词了
            return (value.isWord && size >= 1);
        }
        
        if (value.isWord)
        {
            // 当前节点是单词
            boolean current = isMatch(root, words, value, index + 1, size); // 继续往下遍历
            return current || isMatch(root, words, root, index + 1, size + 1); // 从新的地方开始遍历
        }
        else
        {
            // 当前节点不是单词
            return isMatch(root, words, value, index + 1, size);
        }
    }
    
    /**
     * .当，检查不是由，两个及以上组成时，添加到NTree中
     * @param root 根节点
     * @param words 添加的单词
     */
    private void addWord(NTree root, String words)
    {
        if (words.length() == 0)
        {
            return;
        }
        
        NTree node = root;
        for (int i = 0; i < words.length(); i++)
        {
            node = node.add(words.charAt(i));
        }
        node.isWord = true;
    }
    
    private static class NTree
    {
        private boolean isWord; // 该节点是否是一个单词的结尾
        
        private Map<Character, NTree> valueMap; // 该节点的子内容
        
        private NTree()
        {
            this.isWord = false;
        }
        
        public NTree add(char value)
        {
            if (null == valueMap)
            {
                valueMap = new HashMap<>();
            }
            
            if (valueMap.containsKey(value))
            {
                return valueMap.get(value);
            }
            else
            {
                NTree child = new NTree();
                valueMap.put(value, child);
                return child;
            }
        }
        
        public NTree getValue(char value)
        {
            if (null == valueMap)
            {
                return null;
            }
            return valueMap.get(value);
        }
    }
}
