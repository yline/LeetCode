package com.test.base;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * 有两组 已排序的数组num1 和 num2，长度为 m 和 n
 * 找出两个数组的中间数值，时间复杂度为 O(log(m+n))
 * 
 * Example 1:
 *  nums1 = [1, 3]
 *  nums2 = [2]
 *  The median is 2.0
 * 
 * Example 2:
 *  nums1 = [1, 2]
 *  nums2 = [3, 4]
 *  The median is (2 + 3)/2 = 2.5
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:18:10
 */
public interface Solution
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2);
}
