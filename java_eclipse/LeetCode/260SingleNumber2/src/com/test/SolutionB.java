package com.test;

import com.test.base.Solution;

public class SolutionB implements Solution
{
	public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num: nums) {
            diff ^= num;
        }
        
        // 110, last set is 010, 110  - 1 = 100 inversed = 011 & 110 = 010
        diff &= ~(diff - 1);
        // diff &= -diff;
        
        int a = 0;
        int b = 0;
        for (int num: nums) {
            if ((num & diff) > 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }
}
