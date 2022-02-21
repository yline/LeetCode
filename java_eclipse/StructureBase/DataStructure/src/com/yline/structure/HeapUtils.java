package com.yline.structure;

import java.util.List;

class HeapUtils
{
    /**
     * .从下至上，堆化
     * .默认堆化到第一个
     * @param dataList 数组
     * @param lastIndex 不满足堆化的index[开始的index]
     * @param isMinTop true(小顶堆)，false(大顶堆)
     */
    static <T extends Comparable<T>> void heapifyUp(List<T> dataList, int lastIndex, boolean isMinTop)
    {
        while (lastIndex > 1)
        {
            int preIndex = lastIndex / 2;
            
            boolean childCompare = compare(dataList, preIndex, lastIndex, isMinTop);
            if (childCompare) // 插入不满足要求
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
     * @param isMinTop true(小顶堆)，false(大顶堆)
     */
    static <T extends Comparable<T>> void heapifyDown(List<T> dataList, int pre, int last, boolean isMinTop)
    {
        int preIndex = pre;
        int maxIndex = last / 2; // 最大非叶子点，index
        boolean isOdd = (last & 0x01) == 0; // 长度，是否是奇数
        
        while (preIndex <= maxIndex) // 非叶子节点
        {
            if (isOdd && preIndex == maxIndex) // 一个叶子节点
            {
                boolean childCompare = compare(dataList, preIndex, preIndex * 2, isMinTop);
                if (childCompare)
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
                boolean leftCompare = compare(dataList, preIndex, preIndex * 2, isMinTop);
                boolean rightCompare = compare(dataList, preIndex, preIndex * 2 + 1, isMinTop);
                if (leftCompare || rightCompare)
                {
                    boolean childCompare = compare(dataList, preIndex * 2, preIndex * 2 + 1, isMinTop);
                    int nextIndex = !childCompare ? preIndex * 2 : preIndex * 2 + 1;
                    
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
    
    private static <T extends Comparable<T>> boolean compare(List<T> dataList, int pre, int last, boolean isMinTop)
    {
        T preValue = dataList.get(pre);
        T lastValue = dataList.get(last);
        
        if (isMinTop)
        {
            return preValue.compareTo(lastValue) > 0;
        }
        else
        {
            return preValue.compareTo(lastValue) < 0;
        }
    }
    
    private static <T> void swap(List<T> dataList, int pre, int last)
    {
        if (pre != last)
        {
            T temp = dataList.get(pre);
            dataList.set(pre, dataList.get(last));
            dataList.set(last, temp);
        }
    }
}
