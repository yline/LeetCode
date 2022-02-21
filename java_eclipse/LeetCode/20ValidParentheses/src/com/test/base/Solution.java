package com.test.base;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *      Open brackets must be closed by the same type of brackets.
 *      Open brackets must be closed in the correct order.
 *      
 * Example 1:
 *      Input: "()"
 *      Output: true
 *      
 * Example 2:
 *      Input: "()[]{}"
 *      Output: true
 *      
 * Example 3:
 *      Input: "(]"
 *      Output: false
 *      
 * Example 4:
 *      Input: "([)]"
 *      Output: false
 *      
 * Example 5:
 *      Input: "{[]}"
 *      Output: true
 *      
 * @author YLine
 *
 * 2018年8月14日 上午11:39:42
 */
public interface Solution
{
    /**
     *  ()() // 1,2,3,4 【相减为奇数】
     * @param s
     * @return
     */
    public boolean isValid(String s);
}
