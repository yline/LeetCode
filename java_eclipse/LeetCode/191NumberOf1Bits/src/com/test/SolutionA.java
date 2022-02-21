package com.test;

import com.test.base.Solution;

/**
 * 解题思路：
 * 遍历每一个n，然后累加结果
 * 
 * 时间复杂度：
 * n
 * 
 * @author YLine
 *
 * 2018年7月24日 上午10:10:26
 */
public class SolutionA implements Solution
{
    @Override
    public int hammingWeight(int n)
    {
        int result = 0;
        while (0 != n)
        {
            result += (n & 1);
            n >>>= 1;
        }
        
        return result;
    }
}
