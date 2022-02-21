package com.test.base;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict
 * containing a list of non-empty words,
 * 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * 
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * @author YLine
 *
 * 2019年12月13日 上午10:18:53
 */
public interface Solution
{
    public List<String> wordBreak(String s, List<String> wordDict);
}
