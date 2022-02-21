package com.test;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * 给字符串s和t，判断s是否是t的子串
 * 
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * 
 * s和t由小英文字符组成，t非常长，大于有50W个，s是一个短字符串，长度在100以内
 * 
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * 子串的含义是：从原先的字符串中，按先后顺序取字符串，如果组成某个字符串，则说明，为该字符串
 * 
 * Follow up:延生
 * If there are lots of incoming S, say S1, S2, ... ,
 * Sk where k >= 1B, and you want to check one by one to see if T has its subsequence.
 * In this scenario, how would you change your code?
 * 
 * 如果有很多个子串，如何去判断【AC自动机，tree树】
 * 
 * 思路：
 * 单个直接去单向遍历即可
 *多个，利用tree树去遍历，该题只需要执行单个查询
 * 
 * @author YLine
 *
 * 2019年6月10日 下午2:28:30
 */
public class SolutionA
{
    public boolean isSubsequence(String s, String t)
    {
        if (s.length() == 0)
        {
            return true;
        }
        
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length())
        {
            if (s.charAt(sIndex) == t.charAt(tIndex))
            {
                sIndex++;
                tIndex++;
                
                if (sIndex == s.length())
                {
                    return true;
                }
            }
            else
            {
                tIndex++;
            }
        }
        
        return false;
    }
}
