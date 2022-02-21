package com.test;

import com.test.base.Solution;

/**
 * 解题思路：
 * 参考: https://blog.csdn.net/wconvey/article/details/44705639
 * n&(n-1) 就是对尾部求反
 * 
 * 算法复杂度：
 * log(n)
 * 
 * @author YLine
 *
 * 2018年7月24日 上午10:29:50
 */
public class SolutionB implements Solution
{
    
    @Override
    public int hammingWeight(int n)
    {
        int result = 0;
        while (0 != n)
        {
            result++;
            n &= (n - 1);
        }
        return result;
    }
    
}
