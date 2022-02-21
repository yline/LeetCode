package com.test;

import java.util.Deque;
import java.util.LinkedList;

import com.test.base.Solution;

/**
 * 通过逐渐遍历，贪心算法，一直往右移动；
 * 重点在于，先求和，过滤负数因素导致的非递增情况
 * 
 * @author YLine
 *
 * 2019年5月24日 下午2:50:08
 */
public class SolutionB implements Solution
{
    
    @Override
    public int shortestSubarray(int[] A, int K)
    {
        int[] P = new int[A.length + 1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++)
        {
            P[i + 1] = P[i] + A[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < A.length + 1; i++)
        {
            // 将P中，非单调递增的内容删除
            while (!deque.isEmpty() && P[i] <= P[deque.getLast()]) // 如果x1<y2 且p[y2]<p[x1]则把x1抛弃
            {
                deque.removeLast();
            }
            
            // 从前找满足的位置
            while (!deque.isEmpty() && P[i] - P[deque.getFirst()] >= K)
            {
                res = Math.min(res, i - deque.removeFirst());// 如果满足就把队列中的那个点去掉，因为i之后的点-队列中的点位置肯定比当前点大
            }
            deque.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
}
