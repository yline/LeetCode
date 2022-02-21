package com.test;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * 交织而成
 * 
 * 动态规划，时间复杂度，固定是 n*m，感觉还是挺高的
 * 
 * 用递推，时间复杂度，n+m - n*m，用hashSet作为标记量
 * 
 * @author YLine
 *
 * 2019年9月23日 下午2:01:16
 */
public class SolutionA
{
    public boolean isInterleave(String s1, String s2, String s3)
    {
        if (s1.length() + s2.length() != s3.length())
        {
            return false;
        }
        
        final int ROW = s1.length() + 1;
        final int COLUMN = s2.length() + 1;
        
        boolean[][] stateArray = new boolean[ROW][COLUMN];
        stateArray[0][0] = true;
        
        // 第一行
        for (int j = 1; j < COLUMN; j++)
        {
            stateArray[0][j] = (stateArray[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1)));
        }
        
        // 第一列
        for (int i = 1; i < ROW; i++)
        {
            stateArray[i][0] = (stateArray[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1)));
        }
        
        // 动态规划
        for (int i = 1; i < ROW; i++)
        {
            boolean state = stateArray[i][0];
            for (int j = 1; j < COLUMN; j++)
            {
                char ch = s3.charAt(i+j-1);
                stateArray[i][j] = (stateArray[i][j - 1] && ch == s2.charAt(j - 1))
                    || (stateArray[i - 1][j] && ch == s1.charAt(i - 1));
                
                state |= stateArray[i][j];
            }
            
            // 这一行没有，结束得了
            if (!state)
            {
                return false;
            }
        }

        return stateArray[ROW - 1][COLUMN - 1];
    }
}
