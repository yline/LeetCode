package com.test.base;

import java.util.List;

/**
 * 
 * Given an array of strings, group anagrams together.
 * 给一组字符串，打乱顺序，将字符串相同的字符串组队
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @author YLine
 *
 * 2018年11月29日 下午3:21:38
 */
public interface Solution
{
    public List<List<String>> groupAnagrams(String[] strs);
}
