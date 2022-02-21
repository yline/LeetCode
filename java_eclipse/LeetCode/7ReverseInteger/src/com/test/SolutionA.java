package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:32:21
 */
public class SolutionA implements Solution
{
    @Override
    public int reverse(int x)
    {
        // 防止溢出
        long result = 0;
        
        int signX = x > 0 ? 1 : -1;
        int absX = x > 0 ? x : -x;
        
        // 个位位0，首位为最高位
        List<Integer> numList = new ArrayList<>(32);
        while (absX != 0)
        {
            numList.add(absX % 10);
            absX = absX / 10;
        }
        
        System.out.println("list = " + numList.toString());
        
        // 方向反掉，因此，0是首位，最高位为个位
        long multiply = 1;
        for (int i = numList.size() - 1; i >= 0; i--)
        {
            result += numList.get(i) * multiply;
            multiply *= 10;
        }
        
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
        {
            return 0;
        }
        
        return (int)(signX * result);
    }
}
