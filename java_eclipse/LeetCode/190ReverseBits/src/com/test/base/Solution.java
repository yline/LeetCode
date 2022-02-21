package com.test.base;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 颠倒一个32位无符号字符串
 * 
 * 输出也不考虑，是否是有符号字符串
 * 
 * Example
 * Input: 43261596   as 00000010100101000001111010011100, 
 * Output: 964176192 as 00111001011110000010100101000000.
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:32:21
 */
public interface Solution
{
    /**
     * you need treat n as an unsigned value
     * @param n 无符号数值
     * @return 颠倒的数值
     */
    public int reverseBits(int n);
}
