package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values,
 * compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * 给4个数组，计算A[i] + B[j] + C[k] + D[l] == 0，组合的个数
 * 
 * To make problem a bit easier,
 * all A, B, C, D have same length of N where 0 ≤ N ≤ 500. // 长度为 0-500之间
 * All integers are in the range of -2^28 to 2^28 - 1  // 单个值在-2^28和2^28-1 之间
 * and the result is guaranteed to be at most 2^31 - 1. // 4个值，结果不超过int的最大值
 * 
 * 思路1：
 * 1，逐个移动方案，可能会导致内容缺失，不可靠
 * 
 * 思路2：
 * 1，将两个数组AB、CD，合并。O(n^2)
 * 2，利用Hash，找相反数。O(n^2)
 * 
 * @author YLine
 *
 * 2019年10月26日 下午6:30:24
 */
public class SolutionA
{
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D)
    {
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        
        buildHash(mapA, A, B);
        buildHash(mapB, C, D);

        int result = 0;
        for (Integer key : mapA.keySet())
        {
            if (mapB.containsKey(-key))
            {
                result += (mapA.get(key) * mapB.get(-key));
            }
        }
        
        return result;
    }
    
    private void buildHash(Map<Integer, Integer> map, int[] a, int[] b)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                int key = a[i] + b[j];
                
                Integer oldValue = map.get(key);
                if (null == oldValue)
                {
                    map.put(key, 1);
                }
                else
                {
                    map.put(key, oldValue + 1);
                }
            }
        }
    }
}
