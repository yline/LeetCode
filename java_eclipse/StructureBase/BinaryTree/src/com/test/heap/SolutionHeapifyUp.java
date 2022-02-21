package com.test.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * .堆化，从下至上，以新增为例
 * @author YLine
 *
 * 2019年3月19日 下午7:45:03
 */
public class SolutionHeapifyUp
{
    /**
     * .创建一个,测试数据
     * @return 数组，为了方便拓展，使用List
     */
    public List<Integer> buildTestSource()
    {
        List<Integer> dataList = new ArrayList<>();
        dataList.add(null); // 首个空
        dataList.addAll(Arrays.asList(33));
        dataList.addAll(Arrays.asList(17, 21));
        dataList.addAll(Arrays.asList(16, 13, 15, 9));
        dataList.addAll(Arrays.asList(5, 6, 7, 8, 1, 2));
        return dataList;
    }
    
    public void insert(List<Integer> dataList, int newValue)
    {
        // 插入最后一个
        dataList.add(newValue);
        
        // 从下至上，堆化
        SolutionHeap.heapifyUp(dataList, dataList.size() - 1);
    }
}
