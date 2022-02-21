package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 普通回溯法，没啥好说的
 * @author YLine
 *
 * 2019年5月5日 下午7:12:04
 */
public class SolutionA implements Solution
{
    
    @Override
    public int totalNQueens(int n)
    {
        Result result = new Result(0);
        
        Board board = new Board(n);
        trackback(board, 0, n, result);
        
        System.out.println("result = " + result.intValue());
        
        return result.intValue();
    }
    
    private void trackback(Board board, int x, int n, Result result)
    {
        if (x >= n)
        {
            result.raise();
            board.print();
            return;
        }
        
        for (int i = 0; i < n; i++)
        {
            if (board.isValid(x, i))
            {
                board.add(x, i);
                trackback(board, x + 1, n, result);
                board.remove(x, i);
            }
        }
    }
    
    public static class Result
    {
        private int sValue;
        
        public Result(int val)
        {
            this.sValue = val;
        }
        
        public void raise()
        {
            sValue++;
        }
        
        public int intValue()
        {
            return sValue;
        }
    }
    
    /**
     * 模拟 棋盘
     */
    public static class Board
    {
        public static final int EMPTY = -1; // 空白
        
        // -1 -> 未填充值；其他：填充的具体值
        private int[][] sBoard;
        
        public Board(int n)
        {
            sBoard = new int[n][n];
            init();
        }
        
        private void init()
        {
            int length = sBoard.length;
            for (int i = 0; i < length; i++)
            {
                for (int j = 0; j < length; j++)
                {
                    sBoard[i][j] = EMPTY;
                }
            }
        }
        
        public void print()
        {
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < sBoard.length; i++)
            {
                sBuilder.append(Arrays.toString(sBoard[i]));
                sBuilder.append('\n');
            }
            System.out.println(sBuilder.toString());
        }
        
        public void add(int x, int y)
        {
            if (sBoard[x][y] == EMPTY)
            {
                sBoard[x][y] = x;
            }
        }
        
        public void remove(int x, int y)
        {
            if (sBoard[x][y] != EMPTY)
            {
                sBoard[x][y] = EMPTY;
            }
        }
        
        // 遍历行，因此，左下、右下、行肯定满足要求
        public boolean isValid(int x, int y)
        {
            // 列，上方
            for (int i = 0; i < x; i++)
            {
                if (sBoard[i][y] != EMPTY)
                {
                    return false;
                }
            }
            
            // 左上斜线
            int x1 = x - 1;
            int y1 = y - 1;
            while (x1 >= 0 && y1 >= 0)
            {
                if (sBoard[x1][y1] != EMPTY)
                {
                    return false;
                }
                x1--;
                y1--;
            }
            
            // 右上斜线
            x1 = x - 1;
            y1 = y + 1;
            while (x1 >= 0 && y1 < sBoard.length)
            {
                if (sBoard[x1][y1] != EMPTY)
                {
                    return false;
                }
                x1--;
                y1++;
            }
            
            // 否则，则合法
            return true;
        }
    }
}
