package com.test.base;

/**
 * .二分法工具类
 * @author YLine
 *
 * 2019年10月28日 上午10:00:35
 */
public class DichUtils
{
    public static int findEqualIndex(int[] array, int value)
    {
        if (null == array || array.length == 0)
        {
            return -1;
        }
        
        return findEqualIndexInner(array, value);
    }
    
    /**
     * .找到与值相等的最小index
     */
    private static int findEqualMinIndexInner(int[] array, int value)
    {
        int left = 0, right = array.length - 1;
        while (left <= right)
        {
            int mid = (left + right) >>> 1;
            if (array[mid] == value)
            {
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
    
    /**
     * .找到与值相等的最大index
     */
    private static int findEqualMaxIndexInner(int[] array, int value)
    {
        int left = 0, right = array.length - 1;
        while (left <= right)
        {
            int mid = (left + right) >>> 1;
            if (array[mid] == value)
            {
                if (mid == array.length - 1 || array[mid + 1] > value)
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
    
    /**
     *  .找到与值相等的index
     */
    private static int findEqualIndexInner(int[] array, int value)
    {
        int left = 0, right = array.length - 1;
        while (left <= right)
        {
            int mid = (left + right) >>> 1;
            if (array[mid] == value)
            {
                return mid;
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
