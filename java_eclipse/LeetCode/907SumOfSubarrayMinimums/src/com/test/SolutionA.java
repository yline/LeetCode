package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 时间复杂度：n*n
 * 
 * 使用的是：动态规划（递归+缓存）
 * 
 * 第一条：
 * min{A1}
 * 第二条：
 * min{A1}
 * min{A1, A2}
 * 第三条：
 * min{A1}
 * min{A1, A2}
 * min{A1, A2, A3}
 * 
 * 因此，从后往前推即可
 * 第n条：
 * min{An}
 * 第n-1条：
 * min{A(n-1)}
 * min{A(n-1), A(n)}
 * 第n-2条：
 * min{A(n-2)}
 * min{A(n-2),A(n-1)}
 * min{A(n-2),A(n-1),A(n)}
 * 
 * 运行超时
 * 
 * @author YLine
 *
 * 2019年5月6日 上午9:17:42
 */
public class SolutionA implements Solution
{
    private long result;
    
    @Override
    public int sumSubarrayMins(int[] A)
    {
        int[] minArray = new int[A.length];
        Arrays.fill(minArray, Integer.MAX_VALUE);
        result = 0;
        
        dfs(A, minArray, A.length - 1);
        
        System.out.println("result = " + result);
        
        return (int)(result % 1000000007);
    }
    
    private void dfs(int[] A, int[] minArray, int index)
    {
        if (index < 0)
        {
            return;
        }
        
        // 更新minArray
        for (int i = minArray.length - 1; i >= index; i--)
        {
            minArray[i] = Math.min(minArray[i], A[index]);
            result += minArray[i];
        }
        
        // 继续下一个递归
        dfs(A, minArray, index - 1);
    }
}
