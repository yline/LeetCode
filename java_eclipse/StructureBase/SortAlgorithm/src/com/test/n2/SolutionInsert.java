package com.test.n2;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * 插入排序法: 比较，若小于，则插入；其他后移
 * 
 * 1，最好情况时间复杂度
 * n*3 ≈ O(n)
 * 
 * 2，最坏情况时间复杂度
 * 2*∑[i] + 2*n ≈ O(n^2)
 * 
 * 3，平均时间复杂度
 * 最大交换次数/2 ≈ 1*[(n-1)*n/4] ≈ O(n^2)
 * 
 * 4，空间复杂度
 * 1 = O(1)
 * 
 * 5，稳定性（是否改变）
 * 稳定
 * 
 * @author YLine
 *
 * 2018年12月27日 下午7:30:53
 */
public class SolutionInsert implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            Node node = array[i];
            
            int j = i - 1;
            for (; j >= 0; j--)
            {
                if (node.value < array[j].value)
                {
                    array[j + 1] = array[j];
                }
                else
                {
                    break;
                }
            }
            array[j + 1] = node;
        }
    }
}
