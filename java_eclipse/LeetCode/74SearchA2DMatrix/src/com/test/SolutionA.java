package com.test;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * 实现一个算法，在矩阵中搜索一个数值
 * 
 * This matrix has the following properties:
 * 满足一下特征：
 * Integers in each row are sorted from left to right.
 * 每行从左到右递增
 * The first integer of each row is greater than the last integer of the previous row.
 * 每行的首个数值  大于  上一行的最后一个数值
 * 
 * 
 * 二分法即可
 * 
 * @author YLine
 *
 * 2019年7月25日 上午11:08:31
 */
public class SolutionA
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix.length == 0 || matrix[0].length == 0)
        {
            return false;
        }
        
        final int ROW = matrix.length;
        final int COLUMN = matrix[0].length;
        if (matrix[0][0] > target || matrix[ROW - 1][COLUMN - 1] < target)
        {
            return false;
        }
        
        int left = 0, right = ROW * COLUMN - 1;
        while (left <= right)
        {
            int mid = (left + right) >>> 1;
            int value = matrix[mid / COLUMN][mid % COLUMN];
            if (value > target)
            {
                right = mid - 1;
            }
            else if (value < target)
            {
                left = mid + 1;
            }
            else
            {
                return true;
            }
        }
        
        return false;
    }
}
