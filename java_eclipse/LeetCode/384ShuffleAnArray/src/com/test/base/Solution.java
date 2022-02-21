package com.test.base;

/**
 * Shuffle[洗牌] a set of numbers without duplicates.

对一个数组进行洗牌；保证每个序列出现的可能相同

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation[序列] of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 * @author YLine
 *
 * 2019年2月2日 上午12:08:44
 */
public abstract class Solution
{
    public Solution(int[] nums)
    {
    }
    
    /** Resets the array to its original configuration and return it. */
    public abstract int[] reset();
    
    /** Returns a random shuffling of the array. */
    public abstract int[] shuffle();
}
