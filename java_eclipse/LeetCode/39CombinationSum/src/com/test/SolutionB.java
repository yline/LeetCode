package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * 方案：DFS
 * 问题在于定义函数；
 * 
 * 案例：{2,3,6,7} target = 7
 * 
 * 公式：f(7) = 2f(5) + 3f(4) + 6f(1) + 7f(0)
 * 若将函数f(n),理解为所有字符{2,3,6,7}，组合成target, 即:3f(4) = 3*2*f(2) + 3*3*f(1) + 3*6*f(-2) + 3*7*f(-3) --> 会导致重复的解
 * 若将函数f(n),理解为  已经取的解之后的字符, 即:3f(4) = 3*3*f(1) + 3*6*f(-2) + 3*7*f(-3) --> 排除了重复的解，是自己需要的
 * 
 * @author YLine
 *
 * 2018年11月12日 下午8:19:04
 */
public class SolutionB implements Solution
{
    @Override
    public List<List<Integer>> combinationSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
        {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        dfs(nums, target, result, path, 0);
        
        return result;
    }
    
    /**
     * 
     * @param nums 数组
     * @param target 目标值
     * @param result 返回的结果值
     * @param path 当前的路径
     * @param index 当前的位置
     */
    private void dfs(int[] nums, int target, List<List<Integer>> result, List<Integer> path, int index)
    {
        if (target < 0)
        {
            return;
        }
        
        if (target == 0)
        {
            result.add(new ArrayList<>(path));
        }
        
        for (int i = index; i < nums.length; i++)
        {
            path.add(nums[i]);
            dfs(nums, target - nums[i], result, path, i);
            path.remove(path.size() - 1);
        }
    }
    
}
