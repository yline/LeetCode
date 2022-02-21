package com.test;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * @author yline
 */
public class SolutionA {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> cache = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
			if (cache.contains(nums[i])) {
				return true;
			}
			
			cache.add(nums[i]);
		}
        
        return false;
    }
}
