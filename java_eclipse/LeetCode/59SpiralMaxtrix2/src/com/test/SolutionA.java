package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 时间复杂度：n*n
 * 
 * 直接递归去遍历一次就好了
 * 
 * @author YLine
 *
 * 2019年5月6日 上午9:17:42
 */
public class SolutionA implements Solution
{
    
    @Override
    public int[][] generateMatrix(int n)
    {
        Matrix matrix = new Matrix(n);
        dfs(matrix, 0);
        
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < matrix.sBoard.length; i++)
        {
            sBuilder.append(Arrays.toString(matrix.sBoard[i]));
            sBuilder.append('\n');
        }
        System.out.println(sBuilder.toString());
        
        return matrix.sBoard;
    }
    
    private void dfs(Matrix matrix, int oritation)
    {
        if (matrix.isEnd())
        {
            return;
        }
        
        matrix.add(oritation);
        dfs(matrix, (oritation + 1) % 4);
    }
    
    public static class Matrix
    {
        private final int[][] sBoard;
        
        private int sIndex;
        
        private int left, right, top, bottom;
        
        public Matrix(int size)
        {
            sBoard = new int[size][size];
            sIndex = 0;
            
            left = 0;
            top = 0;
            right = size - 1;
            bottom = size - 1;
        }
        
        public boolean isEnd()
        {
            return (left > right || top > bottom);
        }
        
        public void add(int oritation)
        {
            if (oritation == 0)
            {
                // 从左往右
                for (int i = left; i <= right; i++)
                {
                    sIndex++;
                    sBoard[top][i] = sIndex;
                }
                top++;
            }
            else if (oritation == 1)
            {
                // 从上往下
                for (int i = top; i <= bottom; i++)
                {
                    sIndex++;
                    sBoard[i][right] = sIndex;
                }
                right--;
            }
            else if (oritation == 2)
            {
                // 从右往左
                for (int i = right; i >= left; i--)
                {
                    sIndex++;
                    sBoard[bottom][i] = sIndex;
                }
                bottom--;
            }
            else
            {
                // 从下往上
                for (int i = bottom; i >= top; i--)
                {
                    sIndex++;
                    sBoard[i][left] = sIndex;
                }
                left++;
            }
        }
    }
}
