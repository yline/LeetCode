package com.test;

import com.test.base.Solution;

/**
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 * 
 * 方案1：最原始
 * 遍历，A[0] -> A[i0]、A[1] -> A[i1]、A[2] -> A[i2]，一直找到最小值；结束条件：left < length && right < length
 * 
 * 方案2：在方案1上优化，优化点1，长度大于当前最小值，直接不考虑【超时】
 * 
 * @author YLine
 *
 * 2019年5月9日 上午8:25:07
 */
public class SolutionA implements Solution
{
    
    @Override
    public int shortestSubarray(int[] A, int K)
    {
        if (A.length == 1)
        {
            return A[0] < K ? -1 : 1;
        }
        
        boolean isEmpty = true;
        int min = A.length - 1;
        for (int i = 0; i < A.length; i++)
        {
            int result = findMin(A, K, i, min, isEmpty);
            if (result != Integer.MAX_VALUE)
            {
                isEmpty = false;
                min = result;
            }
            
            // 提前结束，并且防范limit=0时，无法过滤的情况
            if (result == 0)
            {
                return 1;
            }
        }
        return isEmpty ? -1 : min + 1;
    }
    
    /**
     * limit = right - left
     * @return 新的最小值
     */
    private int findMin(int[] A, int K, int start, int limit, boolean isEmpty)
    {
        if (isEmpty)
        {
            int sum = A[start], right = start;
            while (sum < K)
            {
                right++;
                if (right == A.length)
                {
                    return Integer.MAX_VALUE;
                }
                sum += A[right];
            }
            return right - start;
        }
        else
        {
            int sum = A[start], diff = 0;
            while (sum < K)
            {
                diff++;
                // 已经计算过最后一个，但是还是没有满足条件
                if (start + diff == A.length)
                {
                    return Integer.MAX_VALUE;
                }
                
                // 已经和上一个大小持平，没必要在计算了
                if (diff == limit)
                {
                    return Integer.MAX_VALUE;
                }
                sum += A[start + diff];
            }
            return diff;
        }
    }
    

}


