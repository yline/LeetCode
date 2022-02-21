package com.test.multi.trie;

import java.util.HashMap;

/**
 * 
 * 这里用的是，散列表；实际上可以用数组、有序数组、红黑树等等数据结构
 * 
 * Trie 树结构
 * @author YLine
 *
 * 2019年4月8日 下午4:53:41
 */
public class TrieNode
{
    public boolean isEnd;
    
    public char value;
    
    // 保存下一个，指向的所有的 key，已经对应的TrieNode
    public HashMap<Character, TrieNode> next;
    
    public TrieNode(char value)
    {
        this.isEnd = false;
        this.value = value;
        this.next = new HashMap<>();
    }
    
    /**
     * 插入一个内容
     * @param key 下一个字符
     * @return 下一个字符，对应的节点
     */
    public TrieNode insert(char key)
    {
        if (next.containsKey(key))
        {
            return next.get(key);
        }
        else
        {
            TrieNode trieNode = new TrieNode(key);
            next.put(key, trieNode);
            return trieNode;
        }
    }
    
    /**
     * 找到 下一个字符
     * @param key 下一个字符
     * @return 下一个字符，对应的节点。null if 不存在
     */
    public TrieNode find(char key)
    {
        if (next.containsKey(key))
        {
            return next.get(key);
        }
        return null;
    }
    
    public void setFlag(boolean isEnd)
    {
        this.isEnd = isEnd;
    }
}
