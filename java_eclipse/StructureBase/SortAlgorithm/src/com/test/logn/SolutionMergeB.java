package com.test.logn;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * .并归排序 - 递归实现
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
public class SolutionMergeB implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        Node[] temp = new Node[array.length];
        sort(array, 0, array.length - 1, temp);
    }
    
    private static void sort(Node[] array, int left, int right, Node[] temp)
    {
        if (left < right)
        {
            int mid = (left + right) / 2;
            sort(array, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(array, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(array, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }
    
    private static void merge(Node[] arr, int left, int mid, int right, Node[] temp)
    {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        
        while (i <= mid && j <= right)
        {
            if (arr[i].value <= arr[j].value)
            {
                temp[t++] = arr[i++];
            }
            else
            {
                temp[t++] = arr[j++];
            }
        }
        
        //将左边剩余元素填充进temp中
        while (i <= mid)
        {
            temp[t++] = arr[i++];
        }
        
        //将右序列剩余元素填充进temp中
        while (j <= right)
        {
            temp[t++] = arr[j++];
        }
        
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right)
        {
            arr[left++] = temp[t++];
        }
    }
}
