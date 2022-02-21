package com.test.base;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid.
 * 
 * 有一个字符串，只包含'(' ')' '*', 判断它是否合法
 * 
 * We define the validity of a string by these rules:
 * 合法的条件是：
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 必须是'()'
 * 
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * '*'可以替代'('或')'或空字符串
 * 
 * @author YLine
 *
 * 2019年5月7日 上午9:42:52
 */
public interface Solution
{
    public boolean checkValidString(String s);
}
