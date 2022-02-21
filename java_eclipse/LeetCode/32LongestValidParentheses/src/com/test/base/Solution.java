package com.test.base;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * 给一个仅仅包含'('和')'的字符串，找出其中最长合法的字符串
 * 
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * @author YLine
 *
 * 2018年9月18日 上午11:36:29
 */
public interface Solution
{
    public int longestValidParentheses(String s);
}
