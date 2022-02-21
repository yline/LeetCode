package com.test;

import java.util.Stack;

import com.test.base.Solution;

/**
 * 利用栈 先入先出的特征
 * 算法复杂度： n
 * 
 * @author YLine
 *
 * 2018年8月14日 下午3:23:55
 */
public class SolutionC implements Solution
{
    
    @Override
    public boolean isValid(String s)
    {
        Stack<Character> tempStack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            switch (ch)
            {
                case '(':
                case '[':
                case '{':
                    tempStack.push(ch);
                    break;
                case ')':
                    if (tempStack.isEmpty() || tempStack.pop() != '(')
                    {
                        return false;
                    }
                    break;
                case ']':
                    if (tempStack.isEmpty() || tempStack.pop() != '[')
                    {
                        return false;
                    }
                    break;
                case '}':
                    if (tempStack.isEmpty() || tempStack.pop() != '{')
                    {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            
        }
        return tempStack.isEmpty();
    }
    
}
