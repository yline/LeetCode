package com.test;

import com.test.base.Solution;

/**
 * 先获取某区段最小值；然后比较
 * @author YLine
 *
 * 2018年12月26日 下午5:00:52
 */
public class SolutionB implements Solution
{
    
    @Override
    public int maxChunksToSorted(int[] arr)
    {
        if (arr.length == 0)
        {
            return 0;
        }
        
        int[] minArr = new int[arr.length];
        int min = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--)
        {
            min = Math.min(min, arr[i]);
            minArr[i] = min;
        }
        
        int result = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max, arr[i]);
            if (i == arr.length - 1 || max <= minArr[i + 1])
            {
                result++;
            }
        }
        return result;
    }
}
