package com.test;

/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer)
 * of a researcher, write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 * 
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * 
 * This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 * 
 * Could you solve it in logarithmic time complexity?
 * 
 * 1, h篇，每篇引文 >= h
 * 2, N-h篇，的每篇引文 <= h
 * 
 * @author YLine
 *
 * 2019年11月6日 下午6:40:44
 */
public class SolutionA
{
    public int hIndex(int[] citations)
    {
        if (null == citations || citations.length == 0)
        {
            return 0;
        }
        
        int left = 0, right = citations.length - 1;
        while (left <= right)
        {
            int mid = (left + right) >> 1;
            
            int h = citations.length - mid; // h篇
            if (citations[mid] >= h)
            {
                if (mid == 0 || citations[mid - 1] <= h)
                {
                    return h;
                    // return mid;
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
        
        return 0;
    }
}
