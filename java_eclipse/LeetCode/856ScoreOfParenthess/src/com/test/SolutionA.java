package com.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * 
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * Input: "()"
 * Output: 1
 * 
 * Input: "(())"
 * Output: 2
 * 
 * Input: "()()"
 * Output: 2
 * 
 * Input: "(()(()))"
 * Output: 6
 * 
 *  解题思路：队列
 * 
 * @author YLine
 *
 * 2019年11月29日 下午5:04:36
 */
public class SolutionA
{
    public int scoreOfParentheses(String S)
    {
        if (null == S || S.length() == 0)
        {
            return 0;
        }
        
        Deque<Object> queue = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++)
        {
            switch (S.charAt(i))
            {
                case '(':
                    queue.addLast('(');
                    break;
                case ')':
                    move2Next(queue);
                    break;
                default:
                    // 异常了
                    return -1;
            }
        }
        
        // 计算结果
        int result = 0;
        Object obj = queue.pollLast();
        while (obj instanceof Integer)
        {
            result += (int)obj;
            obj = queue.pollLast();
        }
        return result;
    }
    
    private void move2Next(Deque<Object> queue)
    {
        Object obj = queue.pollLast();
        
        // 前一个 是 '(
        if (obj instanceof Character)
        {
            queue.addLast(1);
        }
        
        // 前一个 是 Integer
        if (obj instanceof Integer)
        {
            int result = (int)obj;
            
            // 如果 再前一个是  int，则累加上来
            Object preObj = queue.pollLast();
            while (preObj instanceof Integer)
            {
                result += (int)preObj;
                preObj = queue.pollLast();
            }
            
            queue.add(result << 1);
        }
    }
}
