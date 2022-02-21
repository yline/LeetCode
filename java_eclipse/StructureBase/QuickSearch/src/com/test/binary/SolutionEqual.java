package com.test.binary;

import com.test.base.Solution;

/**
 * 查找值等于给定值的元素[无重复值]
 * @author YLine
 *
 * 2019年2月26日 上午11:16:19
 */
public class SolutionEqual implements Solution
{
    @Override
    public int bintraySearch(int[] array, int value)
    {
        int left = 0, mid, right = array.length - 1;
        
        while (left <= right)
        {
            mid = (left + right) >> 1;
            if (value > array[mid])
            {
                left = mid + 1;
            }
            else if (value < array[mid])
            {
                right = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        
        return -1;
    }
}
