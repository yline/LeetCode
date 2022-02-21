package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

/**
 * {a,b,c,d,e} --> n; 其中每个字符对应有{cA,cB,cC,cD,cE}个
 *                  0*f(n-a, cB) + a*f(n-a, cB); // 如果 cA = 1
 * 函数f(n, cA) =   
 *                  0*f(n-a, cB) + a*f(n-a, cA-1); // 如果cA > 1
 * 函数f(n, cA)表示，从左a开始到右，目标值为n的结果
 * 函数f(n-a, cB)表示，从左b开始到右，目标值为n-a的结果
 * 函数f(n-a, cA-1)表示，从左a开始到右，目标值为n-a的结果
 * 
 * 他们通过pre标志量实现
 * 
 * @author YLine
 *
 * 2018年11月14日 上午10:43:49
 */
public class SolutionB implements Solution
{
    
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, res, list, target, 0);
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int target, int start)
    {
        if (target == 0)
        {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        // 增加标志量
        int prev = 0;
        for (int i = start; i < nums.length; i++)
        {
            if (nums[i] > target)
            {
                break;
            }
            
            if (prev != nums[i])
            {
                list.add(nums[i]);
                dfs(nums, res, list, target - nums[i], i + 1);
                prev = nums[i];
                list.remove(list.size() - 1);
            }
        }
    }
}
