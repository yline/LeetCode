package com.test.n2;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * 冒泡排序法：每次冒出最新的一个
 * 
 * 1，最好情况时间复杂度
 * 1*(n*2+2) ≈ O(n)
 * 
 * 2，最坏情况时间复杂度
 * 5*∑[i] + 2*n ≈ 5*n*n/2 + 2*n ≈ O(n^2)
 * 
 * 3，平均时间复杂度
 * 最大交换次数/2 ≈ 4*[(n-1)*n/4] ≈ O(n^2)
 * 
 * 4，空间复杂度
 * 2 ≈ O(1)
 * 
 * 5，稳定性（是否改变）
 * 稳定
 * 
 * @author YLine
 *
 * 2018年12月6日 下午10:20:50
 */
public class SolutionBubble implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        for (int i = 0; i < array.length; i++) // 仅仅是次数
        {
            boolean isExchange = false;
            for (int j = 0; j < array.length - i - 1; j++) // 相邻两个交换
            {
                if (array[j].value > array[j + 1].value)
                {
                    Node temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isExchange = true;
                }
            }
            
            // 如果未交换，则提前退出
            if (!isExchange)
            {
                break;
            }
        }
    }
    
}
