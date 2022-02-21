package com.test.n;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * .计数排序[假设范围波动为m]
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
 * 2019年2月21日 下午3:09:01
 */
public class SolutionCounting implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        // 计算最小值和最大值，确定范围
        Node min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++)
        {
            min = array[i].value < min.value ? array[i] : min;
            max = array[i].value > max.value ? array[i] : max;
        }
        
        // 统计每个值对应的数量，空间复杂度增高
        int length = max.value - min.value + 1;
        int[] countArray = new int[length];
        for (int i = 0; i < array.length; i++)
        {
            countArray[array[i].value - min.value]++;
        }
        
        // 统计小于某个值，对应的总数
        int lastCount = countArray[0];
        countArray[0] = 0;
        for (int i = 1; i < countArray.length; i++)
        {
            int thisValue = countArray[i];
            countArray[i] = lastCount;
            lastCount += thisValue;
        }
        
        // 获取一个深度clone的数组，空间复杂度增高
        Node[] cloneArray = new Node[array.length];
        for (int i = 0; i < array.length; i++)
        {
            cloneArray[i] = new Node(array[i].value, array[i].index);
        }
        
        // 最后的值
        for (int i = 0; i < array.length; i++)
        {
            int index = countArray[cloneArray[i].value - min.value]; // 排序之后的位置
            array[index] = cloneArray[i];
            countArray[(cloneArray[i].value - min.value)] += 1; // 使用一次之后，需要增加
        }
    }
}
