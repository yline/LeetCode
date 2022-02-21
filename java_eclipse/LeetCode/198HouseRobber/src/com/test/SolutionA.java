package com.test;

/**
 * https://leetcode.com/problems/house-robber/
 * 
 * 递推式: result[i] = Math.max(nums[i] + result[i-2], nums[i-1] + result[i - 3])
 * 
 * @author yline
 */
public class SolutionA
{
    public int rob(int[] nums) {
    	if (null == nums || nums.length == 0) {
			return 0;
		}
    	
    	if (nums.length == 1) {
			return nums[0];
		}
    	
    	if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
    	
    	if (nums.length == 3) {
			return Math.max(nums[1], nums[0] + nums[2]);
		}
    	
    	int[] maxArray = new int[nums.length];
        
        maxArray[0] = nums[0];
        maxArray[1] = Math.max(nums[0], nums[1]);
        maxArray[2] = Math.max(nums[1], maxArray[0] + nums[2]);

        for (int i = 3; i < nums.length; i++) {
			maxArray[i] = Math.max(nums[i] + maxArray[i-2],
					nums[i-1] + maxArray[i-3]);
		}
        
        return Math.max(maxArray[nums.length - 1], maxArray[nums.length - 2]);
    }
}
