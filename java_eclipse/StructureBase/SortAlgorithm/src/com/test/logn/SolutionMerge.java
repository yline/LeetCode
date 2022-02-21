package com.test.logn;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * .并归排序 - 递推实现
 * 
 * 1，最好情况时间复杂度
 * n*log(n)
 * 
 * 2，最坏情况时间复杂度
 * n*log(n)
 * 
 * 3，平均情况时间复杂度
 * n*log(n)
 * 
 * 4，空间复杂度
 * O(n)
 * 
 * 5，稳定性
 * .稳定
 * 
 * @author YLine
 *
 * 2019年2月20日 上午10:26:05
 */
public class SolutionMerge implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        for (int i = 1; i < array.length; i *= 2)
        {
            passMerge(array, i, array.length);
        }
    }
    
    private void passMerge(Node[] array, int gap, int length)
    {
        int i = 0;
        
        // 归并gap长度的两个相邻子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap)
        {
            merge(array, i, i + gap - 1, i + 2 * gap - 1);
        }
        
        // 余下两个子表，后者长度小于gap
        if (i + gap - 1 < length)
        {
            merge(array, i, i + gap - 1, length - 1);
        }
    }
    
    private void merge(Node[] array, int low, int mid, int high)
    {
        int i = low; // i是第一段序列的下标
        int j = mid + 1; // j是第二段序列的下标
        int k = 0; // k是临时存放合并序列的下标
        Node[] array2 = new Node[high - low + 1]; // array2是临时合并序列
        
        // 扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high)
        {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (array[i].value <= array[j].value)
            {
                array2[k] = array[i];
                i++;
                k++;
            }
            else
            {
                array2[k] = array[j];
                j++;
                k++;
            }
        }
        
        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (i <= mid)
        {
            array2[k] = array[i];
            i++;
            k++;
        }
        
        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (j <= high)
        {
            array2[k] = array[j];
            j++;
            k++;
        }
        
        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++)
        {
            array[i] = array2[k];
        }
    }
}
