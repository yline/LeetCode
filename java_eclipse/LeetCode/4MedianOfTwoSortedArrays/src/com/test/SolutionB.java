package com.test;

import com.test.base.Solution;

/**
 * 解题思路：
 * 数组A:{1,2,3,4,5,6,7,8,9}
 * 数组B:{2,4,6,8,10}
 * 
 * 筛选过程：
 * 1，两个数组，选择中间值，若1 > 2，则移除2的左边和1的右边，若1 < 2，则移除2的右边和1的左边
 * 
 * 第一次筛选：中间值{5， 5} 和 {6， 6}
 * 筛选后数组A:{4, 5, 6, 7, 8, 9}
 * 筛选后数组B:{2, 4}
 * 
 * 第二次筛选：中间值{6， 7} 和 {2， 4}
 * 筛选后数组A:{4,5,6,7}
 * 筛选后数组B:{}
 * 
 * 第三次筛选：数组B为空，故结果为：(5+6)/2 = 5
 * 
 * 
 * 整体思路：(二分法)
 * 前提：
 * 假设数组A和数组B整合后的数组，它的中间值前面共有mid个数字
 * 确定在中间值右边和左边的数字个数是相同的，因此后面共有mid个数字。
 * 
 * 1，用中间值比较，数组A若较小，则左边可以移除；对应的数组B的右边的同等个数，可以移除
 * 2，若某个数组已经全部移除，则另一个数组的中间值就是结果值
 * 3，若比较过程中，两个中间值相等，则这个中间值就是结果值
 * 
 * 算法复杂度：
 * log(m+n)
 * 
 * @author YLine
 *
 * 2018年7月19日 下午5:18:10
 */
public class SolutionB implements Solution
{
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if (null == nums1)
        {
            nums1 = new int[0];
        }
        
        if (nums2 == null)
        {
            nums2 = new int[0];
        }
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        if (length1 < length2)
        {
            // 确保第一个数组比第二个数组长度大
            return findMedianSortedArrays(nums2, nums1);
        }
        
        // 如果长度小的数组长度为0，就返回前一个数组的中位数
        if (length2 == 0)
        {
            return (nums1[(length1 - 1) / 2] + nums1[length1 / 2]) / 2.0;
        }
        
        int lo = 0;
        int hi = length2 * 2; // 较短的一个数组长度
        int mid1;
        int mid2;
        double left1;
        double left2;
        double right1;
        double right2;
        
        int time = 0;
        while (lo <= hi)
        {
            System.out.println("---------------" + (time++) + "-----------");
            
            mid2 = (lo + hi) / 2; // 较短的数组的最后一个值
            mid1 = length1 + length2 - mid2; // 较长的数组的最后一个值
            
            left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            right1 = (mid1 == length1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            System.out.println(String
                .format("mid1(%d), left1(%d, %s), right1(%d, %s)", mid1, (mid1 - 1) / 2, left1, mid1 / 2, right1));
            
            left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            right2 = (mid2 == length2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
            System.out.println(String
                .format("mid2(%d), left2(%d, %s), right2(%d, %s)", mid2, (mid2 - 1) / 2, left2, mid2 / 2, right2));
            
            if (left1 > right2)
            {
                lo = mid2 + 1;
            }
            else if (left2 > right1)
            {
                hi = mid2 - 1;
            }
            else
            {
                double result = (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                System.out.println("result = " + result);
                return result;
            }
        }
        
        return -1;
    }
}
