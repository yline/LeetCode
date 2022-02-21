package com.test;

/**
 * Given two sorted integer arrays nums1 and nums2,
 * merge nums2 into nums1 as one sorted array.
 * .给两个已排序的队列，1,2；将2合并入1
 * 
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space
 * (size that is greater or equal to m + n) to hold additional elements from nums2.
 * 
 * Example:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 * 
 * .思路：
 * 1，将num1全部后移，n个位置
 * 2，遍历num1和num2，进行赋值即可
 * 
 * @author YLine
 *
 * 2019年8月23日 下午6:07:55
 */
public class SolutionA
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        // 1，将num1，全部后移n个位置
        System.arraycopy(nums1, 0, nums1, n, m);
        
        // 遍历num1和num2，进行赋值
        int index = 0, indexA = n, indexB = 0;
        while (index < m + n)
        {
            // num2被加完
            if (indexB == n)
            {
                nums1[index] = nums1[indexA];
                index++;
                indexA++;
                continue;
            }
            
            // num1已经达到m
            if (indexA - n == m)
            {
                nums1[index] = nums2[indexB];
                index++;
                indexB++;
                continue;
            }
            
            if (nums1[indexA] > nums2[indexB])
            {
                nums1[index] = nums2[indexB];
                indexB++;
            }
            else
            {
                nums1[index] = nums1[indexA];
                indexA++;
            }
            
            index++;
        }
    }
}
