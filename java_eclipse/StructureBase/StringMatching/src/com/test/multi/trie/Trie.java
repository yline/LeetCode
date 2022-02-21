package com.test.multi.trie;

public class Trie
{
    private TrieNode root = new TrieNode('/'); // 存储无意义字符
    
    public void insert(String str)
    {
        TrieNode temp = root;
        for (int i = 0; i < str.length(); i++)
        {
            temp = temp.insert(str.charAt(i));
        }
        temp.setFlag(true);
    }
    
    public boolean find(String str)
    {
        TrieNode temp = root;
        for (int i = 0; i < str.length(); i++)
        {
            temp = temp.find(str.charAt(i));
            if (null == temp)
            {
                return false;
            }
        }
        return temp.isEnd;
    }
}
