package com.test.base;

/**
 * Given n balloons, indexed from 0 to n-1.
 * 
 * Each balloon is painted with a number on it represented by array nums.
 * 
 * You are asked to burst all the balloons.
 * 
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * 
 * Here left and right are adjacent indices of i.
 * 
 * After the burst, the left and right then becomes adjacent.
 * 
 * 假设第i个为最后一个扎破的气球。
 * 若有切割，则可能会用到切割项。因此，重新定义maxCoins()
 * 
 * 假设数组为，a{0,1,2,3,...,n-1,n}
 * 1, 当我们在a{0,1,2,3,...,n-1,n}，选择最后一个气球，则等于 a{0,1,2,...,k-1} + a{k+1,...,n-1,n} + 1*a[k]*1 （因为k是最后选的）
 * 2，上述a{0,1,2,...,k-1}，再分，则等于a{0,1,2,...,i-1} + a{i+1,...,k-2,k-1} + 1*a[i]*a[k] （因为i是最后选择，而之前分割有系数a[k]）
 * 3，因此，对于任意的a{x,x+1,...,y-1,y}
 * 以k为分界点，等于 a{x,x+1,...,k-1} + a{k+1,k+2,...,n-1,n} + a[x-1]*a[k]*a[n+1]，若越界，则值为1
 * 
 * 记fun(x, y) = a{x,...,y}的值。
 * 等于 a{x,x+1,...,k-1} + a{k+1,k+2,...,n-1,n} + a[x-1]*a[k]*a[n+1]；将K进行遍历，求得的最大值
 * 
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * @author YLine
 *
 * 2019年11月5日 下午2:30:03
 */
public interface Solution
{
    public int maxCoins(int[] nums);
}
