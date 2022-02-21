package com.test.base;

/**
 * You are given an n x n 2D matrix representing an image.
 * 有一个 n*n的矩阵
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 顺时针旋转 90du
 * 
 * Note:
 * You have to rotate the image in-place, which means you have to 
 * modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * 小提示：不允许申请 又一个 n*n的矩阵内存
 * 
 * Example 1:
 * 
 * Given input matrix = 
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 * 
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ], 
 * 
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * 
 * @author YLine
 *
 * 2018年11月29日 下午12:42:46
 */
public interface Solution
{
    public void rotate(int[][] matrix);
}
