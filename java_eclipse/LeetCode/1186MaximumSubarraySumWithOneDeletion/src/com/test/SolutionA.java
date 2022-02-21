package com.test;

/**
 * Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements)
 * with at most one element deletion.【最多删除1个元素】
 * 
 * In other words, you want to choose a subarray and
 * optionally delete one element from it so that
 * there is still at least one element left and the sum of the remaining elements is maximum possible.
 * 
 * Note that the subarray needs to be non-empty after deleting one element.
 * 
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i] <= 10^4
 * 
 * @author YLine
 *
 * 2019年12月2日 下午1:45:17
 */
public class SolutionA
{
    public int maximumSum(int[] arr)
    {
        if (null == arr || arr.length == 0)
        {
            return 0;
        }
        
        // 右侧
        int[] rightMaxArray = new int[arr.length];
        rightMaxArray[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--)
        {
            rightMaxArray[i] = rightMaxArray[i + 1] > 0 ? rightMaxArray[i + 1] + arr[i] : arr[i];
        }
        
        // 左侧
        int max0 = arr[0]; // 没有删除值时最大值
        for (int i = 1; i < arr.length; i++)
        {
            arr[i] = arr[i - 1] > 0 ? arr[i - 1] + arr[i] : arr[i];
            max0 = Math.max(max0, arr[i]);
        }
        
        int max1 = arr[0]; // 删除了1个的最大值
        // 左侧 + 右侧
        int index = 0;
        while (index + 2 < arr.length)
        {
            max1 = Math.max(max1, arr[index] + rightMaxArray[index + 2]);
            index++;
        }
        
        return Math.max(max0, max1);
    }
}
