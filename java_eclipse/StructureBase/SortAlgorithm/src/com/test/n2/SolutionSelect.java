package com.test.n2;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * 选择排序，选择最小的插入；已排序的最后一个
 * 
 * 1，最好情况时间复杂度
 * ∑[i] + 2*n ≈ O(n^2)
 * 
 * 2，最坏情况时间复杂度
 * 2*∑[i] + 5*n ≈ O(n^2)
 * 
 * 3，平均时间复杂度
 * 最大交换次数/2 ≈ 4*[n*(n-1)/4] ≈ O(n^2)
 * 
 * 4，空间复杂度
 * 2 ≈ O(1)
 * 
 * 5，稳定性（是否改变）
 * 不稳定
 * 
 * @author YLine
 *
 * 2018年12月27日 下午8:12:39
 */
public class SolutionSelect implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++)
            {
                minIndex = array[j].value < array[minIndex].value ? j : minIndex;
            }
            
            if (minIndex != i)
            {
                Node temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
