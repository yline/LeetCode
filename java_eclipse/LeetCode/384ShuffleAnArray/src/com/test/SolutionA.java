package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 找出下一个全排列即可
 * @author YLine
 *
 * 2019年2月2日 上午12:34:49
 */
public class SolutionA extends Solution
{
    private int[] originArray;
    
    private int[] tempArray;
    
    public SolutionA(int[] nums)
    {
        super(nums);
        originArray = nums;
        
        tempArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            tempArray[i] = nums[i];
        }
    }
    
    @Override
    public int[] reset()
    {
        return originArray;
    }
    
    @Override
    public int[] shuffle()
    {
        int n = tempArray.length;
        if (n < 2)
        {
            return tempArray;
        }
        
        // 找出从右到左，逆序的index
        int index = n - 1;
        while (index > 0)
        {
            if (tempArray[index - 1] < tempArray[index])
            {
                break;
            }
            index--;
        }
        
        // 如果是完全逆序，则返回最小数
        if (index == 0)
        {
            Arrays.sort(tempArray, 0, n);
            return tempArray;
        }
        else // 否则按照既定规则，排序一次即可
        {
            int val = tempArray[index - 1];
            int j = n - 1;
            while (j >= index)
            {
                if (tempArray[j] > val)
                {
                    break;
                }
                j--;
            }
            
            swapIfNotEqual(tempArray, j, index - 1);
            
            Arrays.sort(tempArray, index, n);
            return tempArray;
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
