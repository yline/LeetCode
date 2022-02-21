package com.test;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 有一个机器人，在左上方，总共有m*n个格子
 * 
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 机器人，只能往右或往下
 * 
 * How many possible unique paths are there?
 * 请问有多少种移动到终点的可能性
 * 
 * 思路：动态规划
 * 可优化的点：空间可以减少使用，用两行即可
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA
{
    public int uniquePaths(int m, int n)
    {
        int[][] matrix = new int[n][m];
        
        // 第一列
        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i][0] = 1;
        }
        
        // 第一行
        for (int i = 0; i < matrix[0].length; i++)
        {
            matrix[0][i] = 1;
        }
        
        // 遍历
        for (int i = 1; i < matrix.length; i++)
        {
            for (int j = 1; j < matrix[0].length; j++)
            {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        
        return matrix[n - 1][m - 1];
    }
}
