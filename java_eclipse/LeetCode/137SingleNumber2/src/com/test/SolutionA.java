package com.test;

import com.test.base.Solution;

/**
 * Given a non-empty array of integers,
 * every element appears three times except for one, which appears exactly once.
 * Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * 
 * Example 1:
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * Example 2:
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 
 * 方案1：
 * 使用hashMap记录个数，3个就移除；
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * 方案2：
 * 找办法，让3个相同的值产生消除效果；二进制或与失败
 * 于是构思，3进制；效果：0+0 = 0,1+1=2,0+1=1,1+2=0；
 * 
 * @author YLine
 *
 * 2019年12月11日 上午9:30:07
 */
public class SolutionA implements Solution
{
    @Override
    public int singleNumber(int[] nums)
    {
        if (null == nums || nums.length == 0)
        {
            return 0;
        }
        
        long result = nums[0]; // 合并的值
        for (int i = 1; i < nums.length; i++)
        {
            result = compile(result, nums[i]);
        }
        
        int sign = nums[0] >= 0 ? 0 : 1; // 合并的符号
        for (int i = 1; i < nums.length; i++)
        {
            int iSign = nums[i] >= 0 ? 0 : 1;
            sign += iSign;
        }
        
        return (sign % 3) == 0 ? (int)result : (int)-result;
    }
    
    /**
     * 实现两个整数，合并值
     */
    private long compile(long x, long y)
    {
        x = Math.abs(x);
        y = Math.abs(y);
        
        long result = 0;
        long multi = 1;
        while (x != 0 || y != 0)
        {
            result += (multi * add((int)(x % 3), (int)(y % 3)));
            
            multi *= 3;
            x /= 3;
            y /= 3;
        }
        
        return result;
    }
    
    /**
     * 实现，依据3进制规则进行加法
     * @param a 0,1,2
     * @param b 0,1,2
     * @return
     */
    private int add(int a, int b)
    {
        return (a + b) % 3;
    }
}
