package com.test.base;

import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 给定一个数组，可能包含重复的数据；返回所有可能的排列
 * 
 * 坑点：数组并不一定以升序排列
 * 
 * @author YLine
 *
 * 2018年11月19日 下午3:37:07
 */
public interface Solution
{
    public List<List<Integer>> permuteUnique(int[] nums);
}
