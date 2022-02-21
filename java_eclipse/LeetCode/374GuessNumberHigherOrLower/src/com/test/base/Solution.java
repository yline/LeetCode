package com.test.base;

/**
 * We are playing the Guess Game. The game is as follows:
 * 
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number is higher or lower.
You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

Example:
Input: n = 10, pick = 6
Output: 6

 * @author YLine
 *
 * 2018年12月25日 下午1:35:24
 */
public abstract class Solution
{
    private int realValue = 0;
    
    /**
     * 调用的API
     * @param n 参数
     * @return 返回值
     */
    public abstract int guessNumber(int n);
    
    /**
     * 依据给的值
     * @param num 给值
     * @return -1（num大了）1（num小了）0（对了）
     */
    public int guess(int num)
    {
        if (num > realValue)
        {
            return -1;
        }
        else if (num < realValue)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public void setRealValue(int value)
    {
        this.realValue = value;
    }
}
