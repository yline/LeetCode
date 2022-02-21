package com.test.base;

/**
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 * 
 * 给一串数字A，B代表A的连续子集；求B中所有最小值，的和
 * 
 * 例如：输入【3,1,2,4】
 * B为：[3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]
 * 对应最小值为：3, 1, 2, 4, 1, 1, 2, 1, 1, 1
 * 和为：17
 * 
 * @author YLine
 *
 * 2019年5月7日 上午9:42:52
 */
public interface Solution
{
    public int sumSubarrayMins(int[] A);
}
