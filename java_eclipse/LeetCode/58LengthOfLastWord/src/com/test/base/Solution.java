package com.test.base;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * 
 * 给一个由 大小字符串、空格组成的字符串，返回最后一个单词的长度
 * 
 * If the last word does not exist, return 0.
 * 如果不存在，则返回0
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 单词的定义为：空格区分
 * 
 * @author YLine
 *
 * 2019年5月6日 下午11:26:56
 */
public interface Solution
{
    public int lengthOfLastWord(String s);
}
