package com.test.binary;

import com.test.base.Solution;

/**
 * 查找第一个大于等于给定值的元素
 * @author YLine
 *
 * 2019年2月26日 下午1:32:54
 */
public class SolutionBiggerFirst implements Solution
{
    
    @Override
    public int bintraySearch(int[] array, int value)
    {
        int left = 0, mid, right = array.length - 1;
        
        while (left <= right)
        {
            mid = (left + right) >> 1;
            
            if (array[mid] >= value)
            {
                // 第一个大于等于给定值的元素
                if (mid == 0 || array[mid - 1] < value)
                {
                    return mid;
                }
                else
                {
                    right = mid - 1;
                }
            }
            else
            {
                left = mid + 1;
            }
        }
        
        return -1;
    }
    
}
