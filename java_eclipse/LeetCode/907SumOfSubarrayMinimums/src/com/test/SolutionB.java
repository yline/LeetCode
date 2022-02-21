package com.test;

import com.test.base.Solution;

/**
 * 时间复杂度：n*n
 * 
 * 使用的是：找规律
 * 
 * 已某个字符为中心，假设往左边，大于它的值共有x个；往右边大于等于它的值有y个；
 * 则，该字符被累加的次数 = （x+1）*（y+1）
 * 
 * @author YLine
 *
 * 2019年5月6日 上午9:17:42
 */
public class SolutionB implements Solution
{
    
    @Override
    public int sumSubarrayMins(int[] A)
    {
        long result = 0;
        
        for (int i = 0; i < A.length; i++)
        {
            int left = findLeft(A, i);
            int right = findRight(A, i);
            
            System.out.println("A[i] = " + A[i] + ", left = " + left + ", right = " + right);
            result += (A[i] * (left + 1) * (right + 1));
        }
        
        System.out.println("result = " + result);
        
        return (int)(result % 1000000007);
    }
    
    private int findLeft(int[] A, int index)
    {
        int temp = index - 1;
        while (temp >= 0)
        {
            if (A[temp] <= A[index])
            {
                break;
            }
            temp--;
        }
        return index - temp - 1;
    }
    
    private int findRight(int[] A, int index)
    {
        int temp = index + 1;
        while (temp < A.length)
        {
            if (A[temp] < A[index])
            {
                break;
            }
            temp++;
        }
        return temp - index - 1;
    }
}
