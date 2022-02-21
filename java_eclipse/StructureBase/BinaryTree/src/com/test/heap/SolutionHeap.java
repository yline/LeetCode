package com.test.heap;

import java.util.List;

/**
 * .堆化
 * 1, 从下至上，堆化
 * 2，从下至上，堆化
 * 
 * @author YLine
 *
 * 2019年3月21日 下午3:34:46
 */
public class SolutionHeap
{
    /**
     * .从下至上，堆化
     * .默认堆化到第一个
     * @param dataList 数组
     * @param lastIndex 不满足堆化的index[开始的index]
     */
    static void heapifyUp(List<Integer> dataList, int lastIndex)
    {
        while (lastIndex > 1)
        {
            int preIndex = lastIndex / 2;
            if (dataList.get(preIndex) < dataList.get(lastIndex)) // 插入不满足要求
            {
                swap(dataList, preIndex, lastIndex);
                lastIndex = preIndex;
            }
            else
            {
                break;
            }
        }
    }
    
    /**
     * .从上至下，堆化
     * @param dataList 数组
     * @param pre 不满足堆化的index[开始的index]
     * @param maxIndex 堆化的结束节点
     */
    static void heapifyDown(List<Integer> dataList, int pre, int last)
    {
        int preIndex = pre;
        int maxIndex = last / 2; // 最大非叶子点，index
        boolean isOdd = (last & 0x01) == 0; // 长度，是否是奇数
        
        while (preIndex <= maxIndex) // 非叶子节点
        {
            if (isOdd && preIndex == maxIndex) // 一个叶子节点
            {
                if (dataList.get(preIndex) < dataList.get(preIndex * 2))
                {
                    swap(dataList, preIndex, preIndex * 2);
                    preIndex *= 2;
                }
                else
                {
                    break;
                }
            }
            else // 两个叶子节点
            {
                if (dataList.get(preIndex) < dataList.get(preIndex * 2) || dataList.get(preIndex) < dataList.get(
                    preIndex * 2 + 1))
                {
                    int nextIndex = (dataList.get(preIndex * 2) > dataList.get(preIndex * 2 + 1) ? preIndex * 2
                        : preIndex * 2 + 1);
                    swap(dataList, preIndex, nextIndex);
                    preIndex = nextIndex;
                }
                else
                {
                    break;
                }
            }
        }
    }
    
    static void swap(List<Integer> dataList, int pre, int last)
    {
        if (pre != last)
        {
            int temp = dataList.get(pre);
            dataList.set(pre, dataList.get(last));
            dataList.set(last, temp);
        }
    }
}
