package com.test;

import java.util.Arrays;

public class SolutionA
{
    /**
     * 检查数独是否合法
     * 
     * 注意：仅仅已填的数字是否合法，即可
     * 
     * 1，先检查行
     * 2，检查列
     * 3，检查九宫格
     * 每次检查，赋值然后校验是否重复赋值即可
     * 
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board)
    {
        // 9行
        for (int i = 0; i < 9; i++)
        {
            if (!isValidLine(board[i]))
            {
                System.out.println("行异常，row " + i);
                return false;
            }
        }
        
        // 9列
        for (int i = 0; i < 9; i++)
        {
            if (!isValidLine(board[0][i],
                board[1][i],
                board[2][i],
                board[3][i],
                board[4][i],
                board[5][i],
                board[6][i],
                board[7][i],
                board[8][i]))
            {
                System.out.println("列异常 column = " + i);
                return false;
            }
        }
        
        // 九宫格
        for (int i = 0; i < 9; i += 3)
        {
            for (int j = 0; j < 9; j += 3)
            {
                if (!isValidLine(board[0 + i][0 + j],
                    board[1 + i][0 + j],
                    board[2 + i][0 + j],
                    board[0 + i][1 + j],
                    board[1 + i][1 + j],
                    board[2 + i][1 + j],
                    board[0 + i][2 + j],
                    board[1 + i][2 + j],
                    board[2 + i][2 + j]))
                {
                    System.out.println("九宫格异常 i = " + i + ", j = " + j);
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * 校验9个字符，是否合法
     * @param symbol 长度为9的数组(实际不要求长度)
     * @return
     */
    public boolean isValidLine2(char... symbol)
    {
        char[] tempArray = new char[symbol.length];
        
        char tempChar;
        int tempIndex;
        for (int i = 0; i < symbol.length; i++)
        {
            tempChar = symbol[i];
            tempIndex = tempChar - '1';
            if (tempChar <= '9' && tempChar >= '1')
            {
                if ('\0' == tempArray[tempIndex])
                {
                    tempArray[tempIndex] = tempChar;
                }
                else
                {
                    System.out.println(Arrays.toString(symbol));
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * 校验9个字符，是否合法，boolean方式，内存最少
     * @param symbol 长度为9的数组(实际不要求长度)
     * @return
     */
    public boolean isValidLine(char... symbol)
    {
        boolean[] tempArray = new boolean[symbol.length];
        
        int index;
        for (int i = 0; i < tempArray.length; i++)
        {
            if (symbol[i] <= '9' && symbol[i] >= '1')
            {
                index = symbol[i] - '1';
                if (!tempArray[index])
                {
                    tempArray[index] = true;
                }
                else
                {
                    System.out.println(Arrays.toString(symbol));
                    return false;
                }
            }
        }
        
        return true;
    }
}
