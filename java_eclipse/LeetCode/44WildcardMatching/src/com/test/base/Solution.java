package com.test.base;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * 给一个字符串和匹配字符串，实现野蛮匹配，支持：'?'和'*'
 * 
 * '?' Matches any single character.
 * '?'匹配任意一个单一字符串
 * '*' Matches any sequence of characters (including the empty sequence).
 * '*'匹配任意字符串，包含空字符串
 * 
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * s可能为null，或者包含a-z的字符串
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * p可能为null，或者包含a-z、?、*的字符串
 * 
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * 
 * Example 2:
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * 
 * Example 3:
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * 
 * Example 4:
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * 
 * Example 5:
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 * 
 * @author YLine
 *
 * 2018年11月19日 下午3:37:07
 */
public interface Solution
{
    public boolean isMatch(String s, String p);
}
