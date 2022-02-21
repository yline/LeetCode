package com.test.base;

import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * 
 * 给定一个数组，和目标值
 * 找出所有的独一无二的队列和，等于目标值
 * 
 * Each number in candidates may only be used once in the combination.
 * 所有数，只允许使用一次
 * 
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * 
 * @author YLine
 *
 * 2018年11月13日 下午7:52:00
 */
public interface Solution
{
    /**
     * @param candidates 数组
     * @param target 目标值
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target);
}
