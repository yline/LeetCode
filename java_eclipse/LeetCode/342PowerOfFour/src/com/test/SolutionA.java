package com.test;

import java.util.HashSet;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 给一个数字，写一个功能，判断它是否是4的指数
 * 
 * Could you solve it without loops/recursion?
 * 不通过循环，就解决
 * 
 * @author YLine
 *
 * 2019年8月30日 上午10:23:30
 */
public class SolutionA
{
    private static final HashSet<Integer> power4Set = new HashSet<>();
    
    static
    {
        for (int i = 0; i <= 32; i += 2)
        {
            power4Set.add(1 << i);
        }
    }
    
    public boolean isPowerOfFour(int num)
    {
        return power4Set.contains(num);
    }
}
