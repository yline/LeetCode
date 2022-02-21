package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 全排列 ~ 字典排序法(相当于找出下一个较大数)
 * 
 * 找出下一个排列（必须是字典排序法，才能找下一个排序）
 * 
 * @author YLine
 *
 * 2018年9月17日 下午5:57:08
 */
public class SolutionA implements Solution
{
    @Override
    public void nextPermutation(int[] nums)
    {
        int n = nums.length;
        if (n < 2)
        {
            return;
        }
        
        // 找出从右到左，逆序的index
        int index = n - 1;
        while (index > 0)
        {
            if (nums[index - 1] < nums[index])
            {
                break;
            }
            index--;
        }
        
        // 如果是完全逆序，则返回最小数
        if (index == 0)
        {
            Arrays.sort(nums, 0, n);
            return;
        }
        else // 否则按照既定规则，排序一次即可
        {
            int val = nums[index - 1];
            int j = n - 1;
            while (j >= index)
            {
                if (nums[j] > val)
                {
                    break;
                }
                j--;
            }
            
            swapIfNotEqual(nums, j, index - 1);
            
            Arrays.sort(nums, index, n);
            return;
        }
    }
    
    /**
     * 交换
     * @param str 数组
     * @param i 交换编号
     * @param j 交换编号
     */
    private void swapIfNotEqual(int[] str, int i, int j)
    {
        if (i != j)
        {
            int temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
