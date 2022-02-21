package com.test;

import java.util.ArrayDeque;

import com.test.base.Solution;

/**
 * 找规律的题目
 * 采用队列这种，先进先出的数据结构；减少内存
 * 
 * @author YLine
 *
 * 2019年5月5日 下午7:12:04
 */
public class SolutionA implements Solution
{
    
    @Override
    public int magicalString(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        
        if (n == 1)
        {
            return 1;
        }
        
        if (n == 2 || n == 3)
        {
            return 1;
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(2);
        
        int patternLength = 2;
        int result = 1;
        
        int currentValue = 1;
        while (!deque.isEmpty())
        {
            // 结束
            if (patternLength >= n)
            {
                return result;
            }
            
            int popValue = deque.poll();
            for (int i = 0; i < popValue; i++)
            {
                deque.add(currentValue);
            }
            
            // 更新数据
            patternLength++;
            currentValue = (currentValue == 1 ? 2 : 1);
            result += (popValue == 1 ? 1 : 0);
        }
        
        return 0;
    }
    
}
