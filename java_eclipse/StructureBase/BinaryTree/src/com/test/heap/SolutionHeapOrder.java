package com.test.heap;

import java.util.List;

/**
 * .堆，排序
 * .利用删除堆顶元素，然后将后面的元素堆化即可
 * 
 * .空间复杂度: n
 * .时间复杂度：建堆 + 排序 = 4*n + n*log(2n)
 * 
 * @author YLine
 *
 * 2019年3月19日 下午7:42:39
 */
public class SolutionHeapOrder
{
    /**
     * .堆排序
     * @param dataList 满足，大顶堆，的数组
     */
    public void heapSort(List<Integer> dataList)
    {
        for (int i = 1; i < dataList.size(); i++)
        {
            SolutionHeap.swap(dataList, 1, dataList.size() - i);
            heapify(dataList, i);
        }
    }
    
    /**
     * .对某一块片段，进行堆化
     * @param dataList 数组
     * @param offset 偏移量
     */
    private void heapify(List<Integer> dataList, int offset)
    {
        int length = dataList.size() - offset;
        SolutionHeap.heapifyDown(dataList, 1, length - 1);
    }
}
