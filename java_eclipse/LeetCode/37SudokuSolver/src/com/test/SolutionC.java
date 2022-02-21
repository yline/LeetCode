package com.test;

import com.test.base.Solution;

/**
 * DFS
 * 
 * 公式：f(n) = 1f(n-1) + 2f(n-1) + 3f(n-1) + 4f(n-1) + 5f(n-1) + 6f(n-1) + 7f(n-1) + 8f(n-1) + 9f(n-1)
 * 函数f(n), 表示为:从左到右,剩余的最终的解
 * 
 * @author YLine
 *
 * 2018年11月13日 上午10:07:46
 */
public class SolutionC implements Solution
{
    private static final char Empty = '.';
    
    @Override
    public void solveSudoku(char[][] board)
    {
        dfs(board, 0);
    }
    
    private boolean dfs(char[][] board, int index)
    {
        for (int k = index; k < 81; k++)
        {
            int i = k / 9;
            int j = k % 9;
            if (Empty == board[i][j])
            {
                index = k;
                for (int x = 0; x < 9; x++)
                {
                    board[i][j] = (char)(x + '1');
                    if (isSingleMatch(board, i, j))
                    {
                        if (dfs(board, index + 1))
                        {
                            return true;
                        }
                        else
                        {
                            board[i][j] = Empty;
                        }
                    }
                    else
                    {
                        board[i][j] = Empty;
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    /**
     * 单个字符，是否符合条件
     * @param board 内容
     * @param i 行
     * @param j 列
     * @return 
     */
    private boolean isSingleMatch(char[][] board, int i, int j)
    {
        // 行
        for (int index = 0; index < board[i].length; index++)
        {
            if (index != j && board[i][j] == board[i][index])
            {
                log(board, i, j, i, index);
                return false;
            }
        }
        
        for (int index = 0; index < board.length; index++)
        {
            if (index != i && board[i][j] == board[index][j])
            {
                log(board, i, j, index, j);
                return false;
            }
        }
        
        int startI = i / 3 * 3;
        int startJ = j / 3 * 3;
        for (int index = 0; index < board.length / 3; index++)
        {
            for (int k = 0; k < board[index].length / 3; k++)
            {
                if (!(i == startI + index && j == startJ + k) && board[i][j] == board[startI + index][startJ + k])
                {
                    log(board, i, j, startI + index, startJ + k);
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void log(char[][] board, int i, int j, int i2, int j2)
    {
        // System.out.println(String.format("(%s, %s, %s) != (%s, %s, %s)", i, j, board[i][j], i2, j2, board[i2][j2]));
    }
}
