package com.test;

/**
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * 给一个矩阵，如果某个值为0，则将该值所在的行和列的值，都变成0
 * 
 * @author YLine
 *
 * 2019年7月22日 上午9:43:00
 */
public class SolutionA
{
    public void setZeroes(int[][] matrix)
    {
        if (matrix.length == 0)
        {
            return;
        }
        
        boolean[] rowArray = new boolean[matrix.length];
        boolean[] columnArray = new boolean[matrix[0].length];
        
        // 遍历第一次，赋值
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    rowArray[i] = true;
                    columnArray[j] = true;
                }
            }
        }
        
        // 第二次遍历，修改值
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (rowArray[i] || columnArray[j])
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
