package com.test.base;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 你在爬阶梯，计算需要多少步，爬到顶峰
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 每次你爬 1或2步，计算多少步到顶峰？
 * 
 * Note: Given n will be a positive integer.
 * 给定的n，一定是正数
 * 
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * @author YLine
 *
 * 2018年11月29日 下午10:22:03
 */
public interface Solution
{
    public int climbStairs(int n);
}
