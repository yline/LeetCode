package com.test;

/**
 * On an 8 x 8 chessboard, there is one white rook(车).
 * There also may be empty squares, white bishops(主教), and black pawns(卒).
 * 
 * These are given as characters 'R', '.', 'B', and 'p' respectively.
 * ##"R"、"."、"B"、"P"代表
 * 
 * Uppercase characters represent white pieces, and lowercase characters represent black pieces.
 * ## 大写代表白色，小写代表黑色
 * 
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
 *  车移动规则：选择四个方向之一，
 * 
 * then moves in that direction until it chooses to stop, reaches the edge of the board,
 * or captures an opposite colored pawn by moving to the same square it occupies.
 *  朝一个方向移动，知道它选择停下来
 * 
 * Also, rooks cannot move into the same square as other friendly bishops.
 * 不能移动到相邻的位置
 * 
 * Return the number of pawns the rook can capture in one move.
 * 返回，一次移动可能捕获的棋子数量总和
 * 
 * Note:
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 * 
 * @author YLine
 *
 * 2019年9月16日 下午2:29:35
 */
public class SolutionA
{
    public int numRookCaptures(char[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if (board[i][j] == 'R')
                {
                    return rookCapture(board, i, j);
                }
            }
        }
        return -1;
    }
    
    private int rookCapture(char[][] board, int x, int y)
    {
        final int N = board.length;
        
        int result = 0;
        for (int i = x; i >= 0; i--)
        {
            if (board[i][y] == 'B')
            {
                break;
            }
            
            if (board[i][y] == 'p')
            {
                result++;
                break;
            }
        }
        
        for (int i = x; i < N; i++)
        {
            if (board[i][y] == 'B')
            {
                break;
            }
            
            if (board[i][y] == 'p')
            {
                result++;
                break;
            }
        }
        
        for (int j = y; j >= 0; j--)
        {
            if (board[x][j] == 'B')
            {
                break;
            }
            
            if (board[x][j] == 'p')
            {
                result++;
                break;
            }
        }
        
        for (int j = y; j < N; j++)
        {
            if (board[x][j] == 'B')
            {
                break;
            }
            
            if (board[x][j] == 'p')
            {
                result++;
                break;
            }
        }
        
        return result;
    }
}
