package com.test.base;

import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * 
 * @author YLine
 *
 * 2018年8月15日 下午5:30:21
 */
public interface Solution
{
    public List<String> generateParenthesis(int n);
}
