package com.test.base;

/**
 * A magical string S consists of only '1' and '2' and obeys the following rules:
 * 有一个字符串，只包含1和2，两个字符；遵循以下规则：
 * 
 * The string S is magical because concatenating the number of contiguous
 * occurrences of characters '1' and '2' generates the string S itself.
 * 
 * The first few elements of string S is the following: S = "1221121221221121122……"
 * 对应包含的自身的内容为：“1 2 2 1 1 2 1 2 2 1 2 2”
 * 
 * Given an integer N as input, return the number of '1's in the first N number in the magical string S.
 * 给“结果”字符串长度，返回包含字符串“1”的个数
 * 
 * @author YLine
 *
 * 2019年5月8日 上午9:04:07
 */
public interface Solution
{
    public int magicalString(int n);
}
