package com.test.base;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 实现找下一个排列，找出逻辑上的较大数（字典排序法下一个）
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 如果不存在下一个排列，则返回逻辑上的最小数（字典排序法第一个）
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 实现方式，只能使用一个额外常量的内存
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 以下便是几个案例
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * 全排列 ~ 字典排序法(相当于找出下一个较大数)
 * 
 * 找出下一个排列（必须是字典排序法，才能找下一个排序）
 * 
 * @author YLine
 *
 * 2018年9月17日 下午5:57:08
 */
public interface Solution
{
    public void nextPermutation(int[] nums);
}
