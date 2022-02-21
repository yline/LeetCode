package com.test.base;

/**
 * Implement atoi to convert a string to an integer.
 * 实现字符串转成 整数
 * 
 * Example 1:
 * Input: "42"
 * Output: 42
 * 
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * 
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * 
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * 
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:34:00
 */
public interface Solution
{
    public int myAtoi(String str);
}
