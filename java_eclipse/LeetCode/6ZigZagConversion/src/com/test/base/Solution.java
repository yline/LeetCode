package com.test.base;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * 原本的字符串，按照"Z"字形写出；然后，输出横向阅读的字符串
 * 
 * Example
 * 
 * Input:  0123456789，numRows = 3
 * 0   4   8
 * 1 3 5 7 9
 * 2   6   
 * Output: 0481357926
 * 
 * Input:  0123456789，numRows = 4
 * 0     6
 * 1   5 7
 * 2 4   8
 * 3     9
 * Output: 06157248390
 *
 * 规律：
 * 
 * 0       2(k-1)     4(k-1)
 * .     . .        . .
 * .   .   .      .   .
 * k-1     3(k-1)     5(k-1)
 * 
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:30:35
 */
public interface Solution
{
    public String convert(String s, int numRows);
}
