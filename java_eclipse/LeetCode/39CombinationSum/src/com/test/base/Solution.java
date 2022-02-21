package com.test.base;

import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * 给定一个候选人集合(没有重复的候选人)，以及一个确定的目标值
 * 找出所有不相同的组合，由已知的候选人组成的组合，候选人之和等于目标值
 * 
 * The same repeated number may be chosen from candidates unlimited number of times.
 * 同一个候选人，可以被选择多次
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * 所有数字，都是正数
 * The solution set must not contain duplicate combinations.
 * 解决方案，不能重复
 * 
 * 案例1：
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 
 * 案例2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * @author YLine
 *
 * 2018年11月5日 下午9:03:45
 */
public interface Solution
{
    public List<List<Integer>> combinationSum(int[] candidates, int target);
}
