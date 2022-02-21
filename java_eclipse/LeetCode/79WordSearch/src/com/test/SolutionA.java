package com.test;

import java.util.HashSet;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 给一个二维矩阵，以及一个单词，判断单词是否存在于二维矩阵中
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * 单词由相邻的字符组成
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * 相邻的含义表示横向或纵向相邻
 * The same letter cell may not be used more than once.
 * 相同的单词，仅能使用1次
 * 
 * 得考虑，如果环形绕回去怎么办
 * 
 * @author YLine
 *
 * 2019年8月12日 上午9:48:38
 */
public class SolutionA
{
    private HashSet<Integer> mPathSet;
    
    public boolean exist(char[][] board, String word)
    {
        if (board.length == 0 || word.length() == 0)
        {
            return false;
        }
        
        mPathSet = new HashSet<>(word.length());
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (dfs(board, i, j, word, 0))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int x, int y, String word, int index)
    {
        // 已经到了最后一个
        if (index == word.length() - 1)
        {
            return word.charAt(index) == board[x][y];
        }
        
        // 一旦失败，直接返回
        if (word.charAt(index) != board[x][y])
        {
            return false;
        }
        
        // 当前是符合条件的
        int key = x + y * board.length;
        mPathSet.add(key);
        
        // 上面(x-1, y)
        boolean up = false;
        if (x > 0 && !mPathSet.contains(key - 1))
        {
            up = dfs(board, x - 1, y, word, index + 1);
        }
        
        // 下面(x+1, y)
        boolean down = false;
        if (x < board.length - 1 && !mPathSet.contains(key + 1))
        {
            down = dfs(board, x + 1, y, word, index + 1);
        }
        
        // 左边(x, y-1)
        boolean left = false;
        if (y > 0 && !mPathSet.contains(key - board.length))
        {
            left = dfs(board, x, y - 1, word, index + 1);
        }
        
        // 右边(x, y+1)
        boolean right = false;
        if (y < board[0].length - 1 && !mPathSet.contains(key + board.length))
        {
            right = dfs(board, x, y + 1, word, index + 1);
        }
        
        // System.out.println(String.format("(%s, %s), (%s, %s, %s, %s)", x, y, left, right, up, down));
        
        boolean result = left || right || up || down;
        if (!result)
        {
            mPathSet.remove(key);
        }
        return result;
    }
}
