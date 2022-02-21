package com.test;

/**
 * 
 * Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
 * 
 * On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
 * 
 * The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
 * 
 * Return the maximum number of customers that can be satisfied throughout the day.
 * 
 * 思路：求出0对应的总和，以及X对应的最大值，和就是结果
 * 
 * @author YLine
 *
 * 2019年5月26日 下午9:09:27
 */
public class SolutionA
{
    public int maxSatisfied(int[] customers, int[] grumpy, int X)
    {
        int sum = 0, max = 0;
        for (int i = 0; i < grumpy.length; i++)
        {
            if (grumpy[i] == 0) // 满意
            {
                sum += customers[i];
            }
            else
            {
                max = Math.max(max, sumOf(customers, grumpy, X, i));
            }
        }
        
        return sum + max;
    }
    
    private int sumOf(int[] customers, int[] grumpy, int X, int start)
    {
        int result = 0;
        for (int i = start; i < start + X; i++)
        {
            // 数组越界处理
            if (i == customers.length)
            {
                return result;
            }
            
            if (grumpy[i] == 1)
            {
                result += customers[i];
            }
        }
        
        return result;
    }
}
