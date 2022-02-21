package com.test.binary;

import com.test.base.Solution;

/**
 * 查找第一个值等于给定值的元素[有重复值]
 * @author YLine
 *
 * 2019年2月26日 上午11:17:53
 */
public class SolutionEqualFirst implements Solution
{
    
    @Override
    public int bintraySearch(int[] array, int value)
    {
        int left = 0, mid, right = array.length - 1;
        
        while (left <= right)
        {
            mid = (left + right) >> 1;
            if (array[mid] == value)
            {
                // 第一个值等于给定元素
                if (mid == 0 || array[mid - 1] < value)
                {
                    return mid;
                }
                else
                {
                    right = mid - 1;
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
