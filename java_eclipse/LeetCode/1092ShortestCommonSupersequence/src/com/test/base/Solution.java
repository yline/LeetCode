package com.test.base;

/**
 * 
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
 * If multiple answers exist, you may return any of them.
 * 
 * 给两个字符串，求同时包含它们的公共字符串，返回最短的，如果存在多个，则返回任何一个都可
 * 
 * (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0,
 * and the characters are chosen anywhere from T) results in the string S.)
 * 子序列：从T中删除一些字符串（可能是0，也可能是任意位置的字符串），可以得到S，则说S是T的子序列
 * 
 * 思路：可以转换成两个字符串模糊匹配，求相似度的问题
 * 
 * a、b两个字符串，某一个结束就到达终点
 * 1，相等时，a往右移，b往右移
 * 2，不相等时，a往右移，添加a[i],或者b往右移，添加b[i]
 * 
 * 递归的方式，貌似总是超时的
 * 
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public interface Solution
{
    public String shortestCommonSupersequence(String str1, String str2);
}
