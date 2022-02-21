package com.test;

/**
 * Given a 2D matrix matrix, find the sum of the elements
 * inside the rectangle defined by its upper left corner (row1, col1)
 *  and lower right corner (row2, col2).
 * 
 *  给两个坐标，求他们之间的数据之和
 * 
 *  You may assume that the matrix does not change.
 *  矩阵值不会变化
 *  There are many calls to sumRegion function.
 *  sumRegion会多次调用
 *  You may assume that row1 ≤ row2 and col1 ≤ col2.
 *  row1 <= row2, col1 <= col2
 * 
 * 思路：
 * 另函数f(x, y) = (0,0)到(x,y)之和
 * 
 * 则sum(x1, y1, x2, y2) = f(x2, y2) - f(x1-1, y2) - f(x2, y1-1) + f(x1-1, y1-1)
 * 
 * @author YLine
 *
 * 2019年6月14日 下午5:04:16
 */
public class SolutionA
{
    private int[][] fMatrix;
    
    public SolutionA(int[][] matrix)
    {
        if (matrix.length == 0)
        {
            return;
        }
        
        fMatrix = new int[matrix.length][matrix[0].length];
        
        // 第一列赋值
        for (int i = 0; i < matrix.length; i++)
        {
            fMatrix[i][0] = matrix[i][0];
        }
        
        // 行求和
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 1; j < matrix[0].length; j++)
            {
                fMatrix[i][j] = fMatrix[i][j - 1] + matrix[i][j];
            }
        }
        
        // 列求和
        for (int j = 0; j < matrix[0].length; j++)
        {
            for (int i = 1; i < matrix.length; i++)
            {
                fMatrix[i][j] += fMatrix[i - 1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2)
    {
        if (null == fMatrix)
        {
            return 0;
        }
        
        if (row1 == 0)
        {
            if (col1 == 0)
            {
                return fMatrix[row2][col2];
            }
            return fMatrix[row2][col2] - fMatrix[row2][col1 - 1];
        }
        else
        {
            if (col1 == 0)
            {
                return fMatrix[row2][col2] - fMatrix[row1 - 1][col2];
            }
            return fMatrix[row2][col2] - fMatrix[row1 - 1][col2] - fMatrix[row2][col1 - 1]
                + fMatrix[row1 - 1][col1 - 1];
            
        }
    }
}
