package com.test;

import com.test.base.Solution;

/**
 * DFS
 * 公式：f(n) = 1f(n) + 2f(n) + 3f(n) + 4f(n) + 5f(n) + 6f(n) + 7f(n) + 8f(n) + 9f(n)
 * 函数f(n), 表示为:从左到右,剩余的最终的解（由于有值，因此，可以直接从0开始遍历）
 * 
 * @author YLine
 *
 * 2018年11月13日 上午11:44:21
 */
public class SolutionA implements Solution
{
    private static final char Empty = '.';
    
    @Override
    public void solveSudoku(char[][] board)
    {
        if (null == board || board.length == 0)
        {
            return;
        }
        
        solve(board);
    }
    
    private boolean solve(char[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (Empty == board[i][j])
                {
                    for (char num = '1'; num <= '9'; num++)
                    {
                        board[i][j] = num; // 尝试
                        
                        if (isValid(board, i, j, num) && solve(board))
                        {
                            return true;
                        }
                        
                        board[i][j] = Empty; // 回退
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int i, int j, char c)
    {
        // check column
        for (int row = 0; row < 9; row++)
        {
            if (i != row && board[row][j] == board[i][j])
            {
                return false;
            }
        }
        
        // check row
        for (int col = 0; col < 9; col++)
        {
            if (j != col && board[i][col] == board[i][j])
            {
                return false;
            }
        }
        
        // check block
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++)
        {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++)
            {
                if ((i != row || col != j) && board[row][col] == board[i][j])
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}
