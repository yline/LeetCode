package com.test.base;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'
 * 输入一个string和pattern，实现支持'.'和'*'的正则匹配
 * 
 * '.' Matches any single character.  '.'匹配任意一个，单个字符
 * '*' Matches zero or more of the preceding element. '*'匹配0到n个,前一个字符
 * 
 * The matching should cover the entire input string (not partial).
 * 匹配，必须匹配整个字符串
 * 
 * Note:
 *  s could be empty and contains only lowercase letters a-z.
 *  p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * 
 * Example 1:
 *  Input:  s = "aa"  p = "a"
 *  Output: false
 *  Explanation: "a" does not match the entire string "aa".
 * 
 * Example 2:
 *  Input:  s = "aa"  p = "a*"
 *  Output: true
 *  Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * Example 3:
 *  Input:  s = "ab"  p = ".*"
 *  Output: true
 *  Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * Example 4:
 *  Input:  s = "aab"  p = "c*a*b"
 *  Output: true
 *  Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * 
 * Example 5:
 *  Input:  s = "mississippi"  p = "mis*is*p*."
 *  Output: false
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:35:03
 */
public interface Solution
{
    public boolean isMatch(String s, String p);
    
}
