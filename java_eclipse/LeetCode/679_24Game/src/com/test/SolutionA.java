package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 思路：
 * 四个数字的计算，其实就是，两个数字计算之后，和另外两个数字计算的结果。
 * 于是，一个递归方案就出来了
 * 
 * @author YLine
 *
 * 2019年5月27日 下午4:48:36
 */
public class SolutionA implements Solution
{
    @Override
    public boolean judgePoint24(int[] nums)
    {
        float[] tempArray = new float[nums.length];
        for (int i = 0; i < tempArray.length; i++)
        {
            tempArray[i] = nums[i];
        }
        
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        
        return dfs(tempArray, visited, 1);
    }
    
    private boolean dfs(float[] numsArray, boolean[] visited, int index)
    {
        if (index == numsArray.length)
        {
            float result = 0.0f;
            for (int i = 0; i < visited.length; i++)
            {
                if (!visited[i])
                {
                    result = numsArray[i];
                    break;
                }
            }
            return (23.9 < result && result < 24.1); // 允许小数点的存在
        }
        
        for (int i = 0; i < numsArray.length; i++)
        {
            if (visited[i]) // 访问过的，直接放过
            {
                continue;
            }
            
            // 移除
            visited[i] = true;
            
            for (int j = i + 1; j < numsArray.length; j++)
            {
                if (visited[j]) // 访问过的，直接放过；而且，先后顺序不对，也放过
                {
                    continue;
                }
                
                float first = numsArray[i];
                float second = numsArray[j];

                // 如果满足，则直接过
                numsArray[j] = first + second;
                boolean isMatch = dfs(numsArray, visited, index + 1);
                if (isMatch)
                {
                    return true;
                }
                
                numsArray[j] = first * second;
                isMatch = dfs(numsArray, visited, index + 1);
                if (isMatch)
                {
                    return true;
                }
                
                numsArray[j] = first - second;
                isMatch = dfs(numsArray, visited, index + 1);
                if (isMatch)
                {
                    return true;
                }
                
                numsArray[j] = first / second;
                isMatch = dfs(numsArray, visited, index + 1);
                if (isMatch)
                {
                    return true;
                }
                
                numsArray[j] = second - first;
                isMatch = dfs(numsArray, visited, index + 1);
                if (isMatch)
                {
                    return true;
                }
                
                numsArray[j] = second / first;
                isMatch = dfs(numsArray, visited, index + 1);
                if (isMatch)
                {
                    return true;
                }
                
                // 数据还原
                numsArray[j] = second;
            }
            
            // 添加回来
            visited[i] = false;
        }
        return false;
    }
}
