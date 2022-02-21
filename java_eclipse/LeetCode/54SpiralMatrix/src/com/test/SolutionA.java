package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

/**
 * 正常的，dfs即可
 * @author YLine
 *
 * 2018年12月18日 上午10:28:19
 */
public class SolutionA implements Solution
{
    @Override
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0)
        {
            return result;
        }
        
        int column = matrix[0].length;
        dfs(matrix, 0, new Rect(row, column), result);
        
        System.out.println(Arrays.toString(result.toArray()));
        
        return result;
    }
    
    private void dfs(int[][] matrix, int oritation, Rect rect, List<Integer> result)
    {
        if (rect.isEnd())
        {
            return;
        }
        
        // 添加内容
        rect.attach(matrix, oritation, result);
        dfs(matrix, (oritation + 1) % 4, rect, result);
    }
    
    public static class Rect
    {
        private int left;
        
        private int right;
        
        private int top;
        
        private int bottom;
        
        public Rect(int row, int column)
        {
            this.left = 0;
            this.top = 0;
            this.right = column - 1;
            this.bottom = row - 1;
        }
        
        public boolean isEnd()
        {
            return (left > right || top > bottom);
        }
        
        public void attach(int[][] matrix, int oritation, List<Integer> result)
        {
            if (oritation == 0) // 从左往右
            {
                for (int i = left; i <= right; i++)
                {
                    result.add(matrix[top][i]);
                }
                top++;
            }
            else if (oritation == 1) // 从上往下
            {
                for (int i = top; i <= bottom; i++)
                {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            else if (oritation == 2) // 从右往左
            {
                for (int i = right; i >= left; i--)
                {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            else // 从下往上
            {
                for (int i = bottom; i >= top; i--)
                {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
    }
}
