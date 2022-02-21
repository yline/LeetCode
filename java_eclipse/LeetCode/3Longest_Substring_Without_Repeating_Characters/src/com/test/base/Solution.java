package com.test.base;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring
 * 
 * 给定字符串，找出其中最长的无重复的字符串
 * 
 * 案例：
 * "abcabcbb" --> "abc", 长度为3
 * "bbbbb" --> "b", 长度为1
 * "pwwkew" --> "wke", 长度为3
 * 
 * Note:
 *  必须是原先字符串中连续的部分
 * 
 * @author YLine
 *
 * 2016年12月15日 下午6:48:27
 */
public interface Solution
{
    int lengthOfLongestSubstring(String s);
}
