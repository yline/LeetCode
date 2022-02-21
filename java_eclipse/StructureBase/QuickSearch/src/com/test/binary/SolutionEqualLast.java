package com.test.binary;

import com.test.base.Solution;

/**
 * 查找最后一个值等于给定值的元素[有重复值]
 * @author YLine
 *
 * 2019年2月26日 上午11:19:17
 */
public class SolutionEqualLast implements Solution
{
    
    @Override
    public int bintraySearch(int[] array, int value)
    {
        final int end = array.length - 1;
        int left = 0, mid, right = end;
        
        while (left <= right)
        {
            mid = (left + right) >> 1;
            if (array[mid] == value)
            {
                // 最后一个等于给定值的元素
                if (mid == end || array[mid + 1] > value)
                {
                    return mid;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else if (array[mid] > value)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        
        return -1;
    }
    
}
