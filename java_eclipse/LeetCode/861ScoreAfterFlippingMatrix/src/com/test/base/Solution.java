package com.test.base;

/**
 * We have a two dimensional matrix A where each value is 0 or 1.
 * 二维矩阵
 * 
 * A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.
 * 数据有0或1，组成；每次转换每行或每列，转换就是所有0-1,1-0
 * 
 * After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
 * 矩阵，每一行代表一个数据
 * 
 * Return the highest possible score.
 * 求矩阵，最大可表示的数据值
 * 
 * @author YLine
 *
 * 2019年5月9日 上午8:23:03
 */
public interface Solution
{
    public int matrixScore(int[][] A);
}
