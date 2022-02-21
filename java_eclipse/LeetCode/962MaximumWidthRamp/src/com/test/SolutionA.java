package com.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array A of integers, a ramp[斜坡] is a tuple[组] (i, j) for which i < j and A[i] <= A[j].
 * 
 * 给一个整数数组，一个连接是一组，如果是递增的（i < j时，有A[i] <= A[j]）
 * 
 * The width of such a ramp is j - i.
 * 斜坡的宽度 = j - i
 * 
 * Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 * 求，数组A中，最大的斜坡宽度，如果不存在，则返回0
 * 
 * 案例：
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：0 < 5; 下标 = 5 - 1 = 4
 * 
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：第一个1，和最后一个1;
 * 
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 * 
 * 思路：
 * 1, 从左往右找，找到第一个不是递减的。获取该值
 * 2，从右往左找，利用上一个获取的最小值，找到比该最小值大的某个值。
 * 
 * 1,2中获取到的队列，无法直接使用，原因是可能有越界的数据满足条件
 * 3，利用1,2中两个值，计算得到宽度，然后，利用此宽度，得到完整的左边队列和右边队列
 * 
 * 4，利用两个队列，同时从最小值到最大值，爬坡对比。即可得到最大值
 * 
 * @author YLine
 *
 * 2019年5月29日 下午7:34:10
 */
public class SolutionA
{
    public int maxWidthRamp(int[] A)
    {
        ArrayDeque<Integer> leftQueue = new ArrayDeque<>();
        int leftEnd = queueLeft(leftQueue, A);
        if (leftEnd == A.length - 1) // 说明，一直是单调递减的
        {
            return 0;
        }
        
        // 获取右侧的单调递减数组
        ArrayDeque<Integer> rightQueue = new ArrayDeque<>();
        int width = queueRight(rightQueue, A, leftEnd);
        
        // 补齐
        fillQueue(leftQueue, rightQueue, A, width);
        
        // 求最大值
        int leftIndex = leftQueue.pollLast(), rightIndex = rightQueue.pollLast();
        while (true)
        {
            if (A[leftIndex] <= A[rightIndex])
            {
                width = Math.max(width, rightIndex - leftIndex);
                
                if (leftQueue.isEmpty())
                {
                    break;
                }
                leftIndex = leftQueue.pollLast();
            }
            else
            {
                if (rightQueue.isEmpty())
                {
                    break;
                }
                rightIndex = rightQueue.pollLast();
            }
        }
        
        return width;
    }
    
    /**
     * A在[0, leftEnd]区间内是单调递减的
     * @param A 数组
     * @return leftEnd
     */
    private int queueLeft(Deque<Integer> queue, int[] A)
    {
        for (int i = 1; i < A.length; i++)
        {
            if (A[i - 1] <= A[i])
            {
                queue.addLast(i - 1);
                return i - 1;
            }
            else
            {
                queue.addLast(i - 1);
            }
        }
        return A.length - 1;
    }
    
    /**
     * 从右往左，一直寻找单调递增的元素，直到大于等于左侧的最小值为止
     * @param queue 队列
     * @param A 数组
     * @param leftMin 左侧已知的最小值的位置
     * @return 找到的位置，减去最小值位置，得到的宽度
     */
    private int queueRight(Deque<Integer> queue, int[] A, int leftMinIndex)
    {
        int leftMin = A[leftMinIndex];

        // 首个校验
        queue.addFirst(A.length - 1);
        if (A[queue.getFirst()] >= leftMin)
        {
            return queue.getFirst() - leftMinIndex;
        }
        
        // 开始循环
        for (int i = A.length - 2; i >= 0; i--)
        {
            if (A[queue.getFirst()] < A[i])
            {
                queue.addFirst(i);
                
                if (A[i] >= leftMin)
                {
                    return i - leftMinIndex;
                }
            }
        }
        
        // 理论上不可能发生
        return -1;
    }
    
    /**
     * 已经获取到左边队列、右边队列、以及当前位置的最大宽度
     * 但是，左边队列和右边队列，可能是不完整的；该函数将它补完整
     * 
     * @param leftQueue 左边队列
     * @param rightQueue 右边队列
     * @param A 数组
     * @param width 当前位置的最大宽度
     */
    private void fillQueue(Deque<Integer> leftQueue, ArrayDeque<Integer> rightQueue, int[] A, int width)
    {
        // 左侧补齐
        int leftStart = leftQueue.getLast() + 1; // 左闭
        int leftEnd = A.length - 1 - width; // 右开
        for (int i = leftStart; i < leftEnd; i++)
        {
            if (A[leftQueue.getLast()] > A[i])
            {
                leftQueue.addLast(i);
            }
        }
        
        // 右侧补齐
        int rightEnd = rightQueue.getFirst() - 1; // 右闭
        int rightStart = width; // 左开
        for (int i = rightEnd; i > rightStart; i--)
        {
            if (A[rightQueue.getFirst()] < A[i])
            {
                rightQueue.addFirst(i);
            }
        }
    }
    
}
