package com.test.base;

import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, 
 * return all possible letter combinations that the number could represent.
 * 给一个仅仅包含2-9字符的字符串，返回它可能代表的所有字符
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * 2 - abc
 * 3 - def
 * 4 - ghi
 * 5 - jkl
 * 6 - mno
 * 7 - qprs
 * 8 - tuv
 * 9 - wxyz
 * 
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @author YLine
 *
 * 2018年8月13日 下午5:16:25
 */
public interface Solution
{
    public List<String> letterCombinations(String digits);
}
