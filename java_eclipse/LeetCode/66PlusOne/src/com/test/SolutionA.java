package com.test;

/**
 * Given a non-empty array of digits representing a non-negative integer,
 * plus one to the integer.
 * 
 * 有一个数组，代表一个正整数；然后求，正整数+1
 * 
 * The digits are stored such that the most significant digit is
 * at the head of the list, and each element in the array contain a single digit.
 * 顺序从前往后
 * 
 * You may assume the integer does not contain any leading zero,
 * except the number 0 itself.
 * 你可以认为，正整数开头不为0，除非它就是0
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA
{
    public int[] plusOne(int[] digits)
    {
        // 实现加法
        int plusValue = 1;
        for (int i = digits.length - 1; i >= 0; i--)
        {
            if (plusValue == 1)
            {
                if (digits[i] == 9)
                {
                    digits[i] = 0;
                }
                else
                {
                    digits[i]++;
                    plusValue = 0;
                }
            }
        }
        
        if (plusValue == 0)
        {
            return digits;
        }
        else
        {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
    }
}
