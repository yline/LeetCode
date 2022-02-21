package com.test.binary;

import com.test.base.Solution;

/**
 * 查找最后一个小于等于给定值的元素
 * @author YLine
 *
 * 2019年2月26日 下午2:02:10
 */
public class SolutionSmallerLast implements Solution
{
    
    @Override
    public int bintraySearch(int[] array, int value)
    {
        final int end = array.length - 1;
        int left = 0, mid, right = end;
        
        while (left <= right)
        {
            mid = (left + right) >> 1;
            
            if (array[mid] <= value)
            {
                if (mid == end || array[mid + 1] > value)
                {
                    return mid;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else
            {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
}
