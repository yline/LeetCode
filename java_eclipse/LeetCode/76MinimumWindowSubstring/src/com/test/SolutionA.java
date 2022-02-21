package com.test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Given a string S and a string T, find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 * 
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * Note:
 * If there is no such window in S that
 * covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there
 * will always be only one unique minimum window in S.
 * 
 * @author YLine
 *
 * 2019年7月25日 下午3:29:51
 */
public class SolutionA
{
    public String minWindow(String s, String t)
    {
        MinHelper helper = new MinHelper(t);
        for (int i = 0; i < s.length(); i++)
        {
            helper.update(s, s.charAt(i), i);
        }
        
        return helper.getResult(s);
    }
    
    private static class MinHelper
    {
        private int count;
        
        private int capacity; // 数组字符的大小
        
        private int[] arrayT; // T的字符串的个数；
        
        private int[] arrayS; // S中T字符串的个数
        
        private ArrayDeque<Integer> deque = new ArrayDeque<>(); // 用于计算最短长度
        
        private MinHelper(String t)
        {
            count = 0;
            capacity = 0;
            arrayT = new int[128];
            Arrays.fill(arrayT, 0);
            
            arrayS = new int[128];
            Arrays.fill(arrayS, 0);
            
            // 统计，t字符串，有效字符的个数，以及对应的值
            for (int i = 0; i < t.length(); i++)
            {
                char ch = t.charAt(i);
                arrayT[ch]++;
                capacity++;
            }
        }
        
        private int min, max;
        
        private void update(String s, char ch, int index)
        {
            // 不符合条件，直接返回
            if (arrayT[ch] == 0)
            {
                return;
            }
            
            if (count != capacity) // 还在累加状态
            {
                if (arrayS[ch] < arrayT[ch])
                {
                    count++;
                    arrayS[ch]++;
                }
                else
                {
                    arrayS[ch]++;
                }
                
                // 添加到队列中
                deque.addLast(index);
                
                // 当最后一个成立，获取当前的最小值
                if (count == capacity)
                {
                    // 遍历移除队列头部
                    while (!deque.isEmpty())
                    {
                        char minCh = s.charAt(deque.getFirst());
                        
                        if (arrayS[minCh] == arrayT[minCh])
                        {
                            break;
                        }
                        
                        deque.removeFirst();
                        arrayS[minCh]--;
                    }
                    
                    min = deque.getFirst();
                    max = deque.getLast();
                }
            }
            else // 累加完成
            {
                arrayS[ch]++;
                deque.add(index);
                
                // 遍历移除队列头部
                while (!deque.isEmpty())
                {
                    char minCh = s.charAt(deque.getFirst());
                    
                    if (arrayS[minCh] == arrayT[minCh])
                    {
                        break;
                    }
                    
                    deque.removeFirst();
                    arrayS[minCh]--;
                }
                
                if (deque.getLast() - deque.getFirst() < max - min)
                {
                    max = deque.getLast();
                    min = deque.getFirst();
                }
            }
        }
        
        private String getResult(String s)
        {
            if (count != capacity)
            {
                return "";
            }
            else
            {
                return s.substring(min, max + 1);
            }
        }
    }
}
