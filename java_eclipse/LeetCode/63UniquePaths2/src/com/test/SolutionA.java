package com.test;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 有一个机器人，在左上方，总共有m*n个格子
 * 
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 机器人，只能往右或往下
 * 
 * 给一个矩阵，1为障碍，0为可通行
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
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1)
        {
            return 0;
        }
        
        int[][] matrix = new int[m][n];
        
        // 第一列
        boolean isBlock = false;
        for (int i = 0; i < matrix.length; i++)
        {
            if (obstacleGrid[i][0] == 1)
            {
                isBlock = true;
            }
            
            matrix[i][0] = isBlock ? 0 : 1;
        }
        
        // 第一行
        isBlock = false;
        for (int i = 0; i < matrix[0].length; i++)
        {
            if (obstacleGrid[0][i] == 1)
            {
                isBlock = true;
            }
            
            matrix[0][i] = isBlock ? 0 : 1;
        }
        
        // 遍历
        for (int i = 1; i < matrix.length; i++)
        {
            for (int j = 1; j < matrix[0].length; j++)
            {
                if (obstacleGrid[i][j] == 1)
                {
                    matrix[i][j] = 0;
                }
                else
                {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }
        
        return matrix[m - 1][n - 1];
    }
}
