package com.test.multi.ac;

import java.util.HashMap;

/**
 * Trie 树结构，为Ac自动机，新增failed指针
 * 
 * 目标问题：在一篇文章(主串)中，查找多个敏感词(模式串)，在文章中，出现的所有位置
 * 
 * @author YLine
 *
 * 2019年4月8日 下午6:10:59
 */
public class AcNode
{
    // 内容
    public char value;
    
    // 下一个内容，以及对应的对象
    public HashMap<Character, AcNode> next;
    
    // 到达该节点，是否，为结束
    public boolean isEnd;
    
    // 如果，该节点匹配失败，则自动匹配到其它节点。如果没有，则为null, 上层处理为root
    public AcNode failed;
    
    // 当前的长度(深度)
    public int length;
    
    public AcNode(char value, int length)
    {
        this.value = value;
        this.next = new HashMap<>();
        this.isEnd = false;
        this.failed = null;
        this.length = length;
    }
    
    /**
     * 插入一个内容
     * @param key 下一个字符
     * @param length 深度
     * @return 下一个字符，对应的节点
     */
    public AcNode insert(char key, int length)
    {
        if (next.containsKey(key))
        {
            return next.get(key);
        }
        else
        {
            AcNode trieNode = new AcNode(key, length);
            next.put(key, trieNode);
            return trieNode;
        }
    }
    
    /**
     * 找到 下一个字符
     * @param key 下一个字符
     * @return 下一个字符，对应的节点。null if 不存在
     */
    public AcNode find(char key)
    {
        if (next.containsKey(key))
        {
            return next.get(key);
        }
        return null;
    }
    
    /**
     * 设置，是否是末尾节点
     * @param isEnd
     */
    public void setFlag(boolean isEnd)
    {
        this.isEnd = isEnd;
    }
    
    @Override
    public String toString()
    {
        String failedStr;
        if (null == failed)
        {
            failedStr = "null";
        }
        else
        {
            failedStr = String.format("{deep: %s, value: %s}", String.valueOf(failed.length), failed.value);
        }
        
        return String.format("{deep: %s, value: %s, isEnd: %s, failed: [%s]}",
            String.valueOf(length),
            value,
            String.valueOf(isEnd),
            failedStr);
    }
}
