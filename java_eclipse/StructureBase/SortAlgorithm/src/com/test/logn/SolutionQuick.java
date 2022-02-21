package com.test.logn;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * .快速排序
 * 
 * 1，最好情况时间复杂度
 * O(n*log(n))
 * 
 * 2，最坏情况时间复杂度
 * O(n^2)
 * 
 * 3，平均情况时间复杂度
 * O(n*log(n))
 * 
 * 4，空间复杂度
 * O(1)
 * 
 * 5，稳定性
 * .不稳定
 * 
 * @author YLine
 *
 * 2019年2月20日 下午4:07:29
 */
public class SolutionQuick implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        sort(array, 0, array.length - 1);
    }
    
    private void sort(Node[] array, int start, int end)
    {
        if (start >= end)
        {
            return;
        }
        
        int pivot = partition(array, start, end);
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);
    }
    
    /**
     * .实现交换,并返回中间分区点
     * @param array 数组
     * @param start 
     * @param end
     * @return 分区点
     */
    private static int partition(Node[] array, int start, int end)
    {
        Node pivot = array[end];
        
        int pre = start;
        for (int i = start; i < end; i++)
        {
            if (array[i].value < pivot.value)
            {
                swap(array, pre, i);
                pre++;
            }
        }
        swap(array, pre, end);
        return pre;
    }
    
    private static void swap(Node[] array, int a, int b)
    {
        if (a != b)
        {
            Node temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }
}
