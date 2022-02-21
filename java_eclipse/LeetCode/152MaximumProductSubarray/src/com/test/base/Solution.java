package com.test.base;

/**
 * Given an integer array nums,
 * find the contiguous subarray within an array (containing at least one number) 连续的子序列
 * which has the largest product. 乘积最大的值
 * 
 * 
Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 主要解决：
 * 1，0的问题，可以采用 分割的形式处理掉
 * 2，符号的问题，
 * 
 * @author YLine
 *
 * 2020年5月13日 下午5:55:59
 */
public interface Solution
{
    public int maxProduct(int[] nums);
}
