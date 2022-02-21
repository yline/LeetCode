package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The gray code is a binary numeral system
 * where two successive values differ in only one bit.
 * gray code是一个二进制系统，其中两个连续值仅在一个位上不同。
 * 
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * 给一个非负数n表示一个数字，打印数字对应的gray code。 gray code开头的数字必须是0
 * 
 * 直接找规律就好了
 * 
 * @author YLine
 *
 * 2019年8月20日 上午10:54:00
 */
public class SolutionA
{
    public List<Integer> grayCode(int n)
    {
        if (n == 0)
        {
            return Arrays.asList(0);
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 1; i <= n; i++)
        {
            int baseValue = (1 << (i - 1));
            for (int j = result.size() - 1; j >= 0; j--)
            {
                result.add(baseValue + result.get(j));
            }
        }
        
        return result;
    }
}
