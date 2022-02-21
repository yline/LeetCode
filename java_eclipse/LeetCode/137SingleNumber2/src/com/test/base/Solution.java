package com.test.base;

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
public interface Solution
{
    public int singleNumber(int[] nums);
}
