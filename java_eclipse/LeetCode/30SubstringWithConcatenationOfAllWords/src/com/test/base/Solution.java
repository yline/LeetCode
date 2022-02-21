package com.test.base;

import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters
 * 
 * 给定，字符串s,以及，多个相同长度的数组，words
 * 
 * 找出，s中，连续包含words拼接而成的字符，例如："foobar","barfoo"
 * 
 * example 1, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * out: [0, 9]
 * 
 * example 2, given:
 * s: "wordgoodstudentgoodword"
 * words: ["word", "student"]
 * out: []
 */
public interface Solution
{
    public List<Integer> findSubstring(String s, String[] words);
}
