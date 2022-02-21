package com.test;

import com.test.base.Solution;

/**
 * 思路和SolutionA一样，但实现的非常优雅
 * @author YLine
 *
 * 2019年12月11日 上午10:33:53
 */
public class SolutionB implements Solution
{
    
    @Override
    public int singleNumber(int[] nums)
    {
        int mod31 = 0;
        int mod32 = 0;
        
        for (int num : nums)
        {
            int n_mod31 = (mod31 ^ num) & ~mod32;
            mod32 = ~(mod31 ^ num) & (mod32 | mod31);
            mod31 = n_mod31;
        }
        
        return mod31 | mod32;
    }
    
}
