package com.test.base;

/**
 * Given a string S, count the number of distinct, non-empty subsequences of S .
 * 
 * 给一个字符串，不为空
 * 
 * 统计子集(不同的)的个数
 * 
 * Since the result may be large, return the answer modulo 10^9 + 7.
 * 由于结果可能很大，因此对 1000000007 求模
 * 
 * @author YLine
 *
 * 2019年5月8日 上午10:17:05
 */
public interface Solution
{
    public int distinctSubseqII(String S);
}
