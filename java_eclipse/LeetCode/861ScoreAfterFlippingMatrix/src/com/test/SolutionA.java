package com.test;

import com.test.base.Solution;

/**
 * 首先，行 --> 首位为0的，替换
 * 第二，列 --> 直接计算0和1的较大值，然后，取值即可
 * 
 * @author YLine
 *
 * 2019年5月9日 上午8:25:07
 */
public class SolutionA implements Solution
{
    
    @Override
    public int matrixScore(int[][] A)
    {
        if (A.length == 0)
        {
            return 0;
        }
        
        for (int x = 0; x < A.length; x++)
        {
            if (A[x][0] == 0)
            {
                reverse(A, x);
            }
        }
        
        // 统计每一列，的较大值
        int[] sizeArray = new int[A[0].length];
        sizeArray[0] = A.length;
        for (int y = 1; y < sizeArray.length; y++)
        {
            int p = 0; // 分别代表0的个数
            for (int x = 0; x < A.length; x++)
            {
                if (A[x][y] == 0)
                {
                    p++;
                }
            }
            
            sizeArray[y] = 2 * p > A.length ? p : A.length - p;
        }
        
        // 计算总和
        int sum = 0;
        for (int y = sizeArray.length - 1; y >= 0; y--)
        {
            sum += (sizeArray[y] * (1 << (sizeArray.length - 1 - y)));
        }
        
        return sum;
    }
    
    private void reverse(int[][] A, int row)
    {
        for (int y = 0; y < A[row].length; y++)
        {
            A[row][y] = A[row][y] == 0 ? 1 : 0;
        }
    }
}
