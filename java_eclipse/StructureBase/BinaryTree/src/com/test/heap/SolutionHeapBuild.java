package com.test.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * .建堆
 * .思路一：
 * .在堆中，插入一个元素，然后依次插入2-n的元素；每次插入都是从下往上堆化
 * .
 * .思路二：
 * .从后往前处理数组，并且每个数据都是从上往下堆化
 * .PS：必须从第一个非叶子节点，从后往前，堆化
 * 
 * .建堆的时间复杂度为O(n)
 * S = (2^0)*h + (2^1)*(h-1) + ... + (2^k)*(h-k) + ... + (2^(h-1))*1 
 * 2*S =       + (2^1)*h + ... + (2^k)*(h-k+1) + ... + (2^h) 
 * 
 * S = -h + 2^1 + 2^2 + ... + 2^k + ... + 2^h = 2^(h+1) - h - 2
 * h = log(2n)
 * .故：S ≈ 4*n
 * 
 * @author YLine
 *
 * 2019年3月19日 下午5:39:20
 */
public class SolutionHeapBuild
{
    public static final int[] valueArray = {7, 5, 19, 8, 4, 1, 20, 13, 16};
    
    public List<Integer> buildDataSource()
    {
        List<Integer> dataList = new ArrayList<>();
        dataList.add(null);
        dataList.addAll(Arrays.asList(7));
        dataList.addAll(Arrays.asList(5, 19));
        dataList.addAll(Arrays.asList(8, 4, 1, 20));
        dataList.addAll(Arrays.asList(13, 16));
        return dataList;
    }
    
    // 从后往前，堆化
    public void buildHeap(List<Integer> dataList)
    {
        int maxIndex = (dataList.size() - 1) / 2; // 最大的非叶子点index
        for (int i = maxIndex; i > 0; i--)
        {
            SolutionHeap.heapifyDown(dataList, i, dataList.size() - 1);
        }
    }
}
