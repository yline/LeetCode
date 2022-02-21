package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

/**
 * {a,b,c,d,e} --> n
 * 
 * 公式：f(n) = a*f(n-a) + 0*f(n-a)
 * 函数f(n)表示，从左0到右，目标值为n的结果
 * f(n-a)表示，从左1到右，目标值为n-a的结果
 * 
 * 以上公式，一般来说没问题，可是，题目允许 a,b,c,d,e中可能有相等的，因此，会导致结果重复
 * 例如：{1,2,2,2,5} --> 5 可能就有(1,2,2),(1,2,2),(1,2,2),(5)
 * 
 * 因此，改成 {a,b,c,d,e} --> n; 其中每个字符对应有{cA,cB,cC,cD,cE}个
 *                  0*f(n-a, cB) + a*f(n-a, cB); // 如果 cA = 1
 * 函数f(n, cA) =   
 *                  0*f(n-a, cB) + a*f(n-a, cA-1); // 如果cA > 1
 * 函数f(n, cA)表示，从左a开始到右，目标值为n的结果
 * 函数f(n-a, cB)表示，从左b开始到右，目标值为n-a的结果
 * 函数f(n-a, cA-1)表示，从左a开始到右，目标值为n-a的结果
 * 
 * @author YLine
 *
 * 2018年11月13日 下午8:05:34
 */
public class SolutionA implements Solution
{
    
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        // 排序
        Arrays.sort(candidates);
        
        // 形成，固定格式
        List<Point> sourceList = new ArrayList<>();
        Point oldPoint = new Point(candidates[0], 1);
        for (int i = 1; i < candidates.length; i++)
        {
            if (candidates[i] == oldPoint.value)
            {
                oldPoint.count++;
            }
            else
            {
                sourceList.add(oldPoint);
                oldPoint = new Point(candidates[i], 1);
            }
        }
        sourceList.add(oldPoint);
        
        // 最终实现
        List<List<Integer>> result = new ArrayList<>();
        dfs(sourceList, target, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void dfs(List<Point> sourceList, int target, List<List<Integer>> result, List<Integer> path, int index)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if (target < 0 || index >= sourceList.size())
        {
            return;
        }
        
        // 0*f(n-a, cB)
        dfs(sourceList, target, result, path, index + 1);
        
        Point nowPoint = sourceList.get(index);
        if (nowPoint.count == 1) // 如果 cA = 1
        {
            // a*f(n-a, cB)
            path.add(nowPoint.value);
            dfs(sourceList, target - nowPoint.value, result, path, index + 1);
            path.remove(path.size() - 1);
        }
        else // 如果cA > 1
        {
            // a*f(n-a, cA-1)
            path.add(nowPoint.value);
            nowPoint.count--;
            dfs(sourceList, target - nowPoint.value, result, path, index);
            nowPoint.count++;
            path.remove(path.size() - 1);
        }
    }
    
    private static class Point
    {
        private int value;
        
        private int count;
        
        public Point(int value, int count)
        {
            this.value = value;
            this.count = count;
        }
    }
}
