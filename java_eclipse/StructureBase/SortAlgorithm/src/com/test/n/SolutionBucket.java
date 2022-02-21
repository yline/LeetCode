package com.test.n;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * .桶排序[假设范围波动为m]
 * 
 * 1，最好情况时间复杂度
 * O(n+m) 
 * 
 * 2，最坏情况时间复杂度
 * O(n+m)
 * 
 * 3，平均情况时间复杂度
 * O(n+m)
 * 
 * 4，空间复杂度
 * O(Math.max(n, m))
 * 
 * 5，稳定性
 * .稳定
 * 
 * @author YLine
 *
 * 2019年2月21日 上午9:55:59
 */
public class SolutionBucket implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        // 先找出最小值和最大值
        Node min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++)
        {
            min = array[i].value < min.value ? array[i] : min;
            max = array[i].value > max.value ? array[i] : max;
        }
        
        // 创建单个桶[数据量少，不做切割了]
        int length = max.value - min.value + 1; // 考虑负数的情况
        ListNode[] bucketArray = new ListNode[length];
        
        // 遍历原始数据，一个一个的放入桶中
        for (int i = 0; i < array.length; i++)
        {
            int index = array[i].value - min.value;
            if (null == bucketArray[index])
            {
                bucketArray[index] = new ListNode(array[i]);
            }
            else
            {
                ListNode temp = bucketArray[index];
                while (null != temp.next)
                {
                    temp = temp.next;
                }
                temp.next = new ListNode(array[i]);
            }
        }
        
        // 取出所有数据，返还给array
        int index = 0;
        for (int i = 0; i < bucketArray.length; i++)
        {
            ListNode temp = bucketArray[i];
            while (null != temp)
            {
                array[index] = temp.value;
                index++;
                temp = temp.next;
            }
        }
    }
    
    private static class ListNode
    {
        private Node value;
        
        private ListNode next;
        
        private ListNode(Node value)
        {
            this.value = value;
        }
    }
}
