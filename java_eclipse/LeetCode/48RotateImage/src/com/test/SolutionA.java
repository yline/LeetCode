package com.test;

import com.test.base.Solution;

/**
 * 对应关系
 * (i, j) -- (n-j, i) -- (n-i, n-j) -- (j, n-i)
 * 
 * 交换：4个位一组; 对应关系如上
 * 
 * 交换单位：
 * 1 -> 0*0
 * 2 -> 1*1
 * 3 -> 1*2
 * 4 -> 2*2
 * 5 -> 2*3
 * 6 -> 3*3
 * 
 * n -> n/2 * (n+1)/2   当n=1时，例外
 * 
 * @author YLine
 *
 * 2018年11月29日 下午12:43:16
 */
public class SolutionA implements Solution
{
    
    @Override
    public void rotate(int[][] matrix)
    {
        if (null == matrix || matrix.length <= 1)
        {
            return;
        }
        
        final int length = matrix.length;
        final int width = length >> 1;
        final int height = (length + 1) >> 1;
        final int side = length - 1; // 边的最大值 + 最小值
        
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                swap(matrix, side, i, j);
            }
        }
    }
    
    /**
     * 顺时针，按照方向走一次
     * (i, j) --> (j, n-i) --> (n-i, n-j) --> (n-j, i)
     */
    private void swap(int[][] matrix, int n, int i, int j)
    {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - j][i];
        matrix[n - j][i] = matrix[n - i][n - j];
        matrix[n - i][n - j] = matrix[j][n - i];
        matrix[j][n - i] = temp;
    }
}
