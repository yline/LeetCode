package com.test;

import java.util.HashSet;

/**
 * Given a positive integer K, you need find the smallest positive integer N
 * such that N is divisible by K, and N only contains the digit 1.
 * 
 * Return the length of N.  If there is no such N, return -1.
 * 
 * 1，f(n) = 10*f(n-1) + 1
 * ==> f(n) % k = 10*f(n-1) % K + 1
 * 
 * 
 * @author YLine
 *
 * 2019年12月2日 下午4:22:03
 */
public class SolutionA
{
    public int smallestRepunitDivByK(int K)
    {
        if (1 == K)
        {
            return 1;
        }
        
        HashSet<Integer> resultSet = new HashSet<>();
        resultSet.add(1);
        
        int index = 0;
        int result = 1;
        while (result != K)
        {
            result = nextResult(result, K);
            index++;
            
            // 已经重复了
            if (resultSet.contains(result))
            {
                return -1;
            }
            resultSet.add(result);
        }
        
        return index + 1;
    }
    
    private int nextResult(int lastRsult, int K)
    {
        return 10 * lastRsult % K + 1;
    }
}
