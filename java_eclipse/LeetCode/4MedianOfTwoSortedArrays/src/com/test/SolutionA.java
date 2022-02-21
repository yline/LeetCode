package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 解题思路：
 * 1，先对两个数组进行比较，生成新的数组
 * 2，取出中间值
 * 
 * 时间复杂度：
 * n
 * 
 * @author YLine
 *
 * 2018年7月19日 下午5:15:24
 */
public class SolutionA implements Solution
{
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int mLength = nums1.length, nLength = nums2.length;
        int[] num3 = new int[mLength + nLength];
        
        int i = 0, j = 0;
        while (i < mLength || j < nLength)
        {
            if (i == mLength)
            {
                num3[i + j] = nums2[j];
                j++;
            }
            else if (j == nLength)
            {
                num3[i + j] = nums1[i];
                i++;
            }
            else if (nums1[i] < nums2[j])
            {
                num3[i + j] = nums1[i];
                i++;
            }
            else
            {
                num3[i + j] = nums2[j];
                j++;
            }
        }
        
        System.out.println(Arrays.toString(num3));
        
        if (num3.length % 2 == 0)
        {
            return (num3[num3.length / 2] + num3[(num3.length / 2) - 1]) * 1.0 / 2;
        }
        else
        {
            return num3[num3.length / 2];
        }
    }
}
