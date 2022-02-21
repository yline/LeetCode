package com.test;

/**
 * Given an array A of non-negative integers,
 *  return an array consisting of all the even elements of A,
 *  followed by all the odd elements of A.
 * 偶数在前，奇数在后
 * 
 * 
 * You may return any answer array that satisfies this condition.
 * @author YLine
 *
 * 2019年10月16日 下午12:31:29
 */
public class SolutionA
{
    public int[] sortArrayByParity(int[] A)
    {
        int left = 0, right = A.length - 1;
        while (left < right)
        {
            // 偶数
            if ((A[left] & 0x1) == 0)
            {
                left++;
                continue;
            }
            
            // 奇数
            if ((A[right] & 0x1) == 1)
            {
                right--;
                continue;
            }
            
            // left为奇数、right为偶数
            swap(A, left, right);
            left++;
            right--;
        }
        
        return A;
    }
    
    private void swap(int[] A, int left, int right)
    {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}
