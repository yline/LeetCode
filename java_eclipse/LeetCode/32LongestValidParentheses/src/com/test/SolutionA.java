package com.test;

import java.util.Stack;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public int longestValidParentheses(String s)
    {
        // 用于记录待匹配的左括号和右括号的位置
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++)
        {
            // 如是当前字符是右括号，并且记录栈非空，并且前一个字符是左括号
            if (s.charAt(i) == ')' && !st.isEmpty() && s.charAt(st.peek()) == '(')
            {
                // 左括号出栈
                st.pop();
                // 求最大值
                // 此时与(匹配的)已经出栈，所以栈要么为空，要么是与当前)最近的)
                // 要么是与当前)第二近的(
                int left = (st.isEmpty() ? -1 : st.peek());
                max = Math.max(max, i - left);
            }
            // 其它情况就将字符入栈
            else
            {
                st.push(i);
            }
        }
        
        return max;
    }
}
