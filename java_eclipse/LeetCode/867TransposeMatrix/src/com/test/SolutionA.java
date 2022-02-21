package com.test;

import com.test.base.Solution;

/**
 * 
 * @author YLine
 *
 * 2019年5月25日 下午8:41:43
 */
public class SolutionA implements Solution
{
    
    @Override
    public int[][] transpose(int[][] A)
    {
        if (A.length == 0)
        {
            return A;
        }
        
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[0].length; j++)
            {
                result[j][i] = A[i][j];
            }
        }
        
        return result;
    }
    
}
