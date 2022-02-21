package com.test;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * Example:
X X X X
X O O X
X X O X
X O X X
 * 
 * After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
 * 
 * Explanation:
 * 1, Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * 2, Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * 3, Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * 
 * 思路：从(1,1)开始，左->右，上->下，右往左，下往上，递归调用
 * 可能，会有漏的。
 * 
 * 思路：
 * 1，从(1,1)开始，将内环所有内容添加，变成一个hashset
 * 2，外环的O，全部加入queue
 * 3，从外环的O，做排除法
 * 
 * @author YLine
 *
 * 2019年11月5日 上午10:26:21
 */
public class SolutionA
{
    public void solve(char[][] board)
    {
        // 任何一处都是边界时，直接过滤掉
        if (null == board || board.length < 3 || board[0].length < 3)
        {
            return;
        }
        
        HashSet<Integer> innerSet = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        // 填充内容
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 'O')
                {
                    int compile = compile(i, j, board[0].length);
                    // 外环
                    if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)
                    {
                        queue.add(compile);
                    }
                    else
                    {
                        innerSet.add(compile);
                    }
                }
            }
        }
        
        min = 0;
        max = board.length * board[0].length - 1;
        
        // 避免重复添加
        HashSet<Integer> outterSet = new HashSet<>();
        outterSet.addAll(queue);
        
        while (!queue.isEmpty())
        {
            int compile = queue.pollFirst();
            
            int leftCompile = compile - 1;
            int rightCompile = compile + 1;
            int topCompile = compile - board[0].length;
            int bottomCompile = compile + board[0].length;
            
            if (isO(board, leftCompile) && !outterSet.contains(leftCompile))
            {
                // 清除内环
                innerSet.remove(leftCompile);
                
                // 加入标记
                outterSet.add(leftCompile);
                queue.add(leftCompile);
            }
            
            if (isO(board, rightCompile) && !outterSet.contains(rightCompile))
            {
                // 清除内环
                innerSet.remove(rightCompile);
                
                // 加入标记
                outterSet.add(rightCompile);
                queue.add(rightCompile);
            }
            
            if (isO(board, topCompile) && !outterSet.contains(topCompile))
            {
                // 清除内环
                innerSet.remove(topCompile);
                
                // 加入标记
                outterSet.add(topCompile);
                queue.add(topCompile);
            }
            
            if (isO(board, bottomCompile) && !outterSet.contains(bottomCompile))
            {
                // 清除内环
                innerSet.remove(bottomCompile);
                
                // 加入标记
                outterSet.add(bottomCompile);
                queue.add(bottomCompile);
            }
        }
        
        // 修改值
        for (Integer key : innerSet)
        {
            int x = key / board[0].length;
            int y = key % board[0].length;
            board[x][y] = 'X';
        }
    }
    
    private int min, max;
    
    private int compile(int x, int y, int length)
    {
        return x * length + y;
    }
    
    private boolean isO(char[][] board, int compile)
    {
        if (compile < min || compile > max)
        {
            return false;
        }
        
        int x = compile / board[0].length;
        int y = compile % board[0].length;
        return board[x][y] == 'O';
    }
}
