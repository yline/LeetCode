package com.test.base;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

只考虑，大写字母、小写字母、数字；并忽略大小写

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

 * @author YLine
 *
 * 2018年12月12日 上午10:21:42
 */
public interface Solution
{
    public boolean isPalindrome(String s);
}
