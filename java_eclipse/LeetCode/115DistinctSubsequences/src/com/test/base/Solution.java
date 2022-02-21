package com.test.base;

/**
 * 
Given a string S and a string T, count the number of distinct subsequences of S which equals T.
给字符串s 和 t, 计算 s中有多少可能性，组成t

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
从头到尾选取字符串，可跳过
例如：ABCDE 可以组成 ACE 但是不能组成 AEC

Example 1:
Input: S = "rabbbit", T = "rabbit"
Output: 3

Explanation:
rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^

Example 2:
Input: S = "babgbag", T = "bag"
Output: 5

Explanation:
babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
 * 
 * 
 * 
 * @author YLine
 *
 * 2018年11月30日 上午9:36:13
 */
public interface Solution
{
    public int numDistinct(String s, String t);
}
