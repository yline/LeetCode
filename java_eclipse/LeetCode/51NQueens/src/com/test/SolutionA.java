package com.test;

import java.util.ArrayList;
import java.util.List;

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
    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> result = new ArrayList<>();
        
        Board board = new Board(n);
        trackback(board, 0, n, result);

        return result;
    }
    
    private void trackback(Board board, int x, int n, List<List<String>> result)
    {
        if (x >= n)
        {
            board.print(result);
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
    
    /**
     * 模拟 棋盘
     */
    public static class Board
    {
        public static final char QUEEN = 'Q'; // 皇后
        
        public static final char EMPTY = '.'; // 空白
        
        // -1 -> 未填充值；其他：填充的具体值
        private char[][] sBoard;
        
        public Board(int n)
        {
            sBoard = new char[n][n];
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
        
        public void print(List<List<String>> result)
        {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < sBoard.length; i++)
            {
                temp.add(new String(sBoard[i]));
            }
            result.add(temp);
            
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append('[');
            sBuilder.append('\n');
            for (int i = 0; i < temp.size(); i++)
            {
                sBuilder.append(temp.get(i));
                sBuilder.append(',');
                sBuilder.append('\n');
            }
            sBuilder.append(']');
            System.out.println(sBuilder.toString());
        }
        
        public void add(int x, int y)
        {
            if (sBoard[x][y] == EMPTY)
            {
                sBoard[x][y] = QUEEN;
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
