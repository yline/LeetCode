package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 我是看答案，得来的
 * 
 * 简单的理解就是：并归排序的思维，先拆分，后合并
 * 
 * 时间复杂度：O(n*logn)
 * 空间复杂度：O(n)
 * 
 * @author YLine
 *
 * 2019年5月29日 下午2:50:07
 */
public class SolutionC implements Solution
{
    
    @Override
    public int reversePairs(int[] nums)
    {
        return doReversePairs(nums, 0, nums.length - 1);
    }
    
    private int doReversePairs(int[] nums, int l, int u)
    {
        if (l >= u)
        {
            return 0;
        }
        int mid = l + (u - l) / 2;
        int rvLeft = doReversePairs(nums, l, mid);
        int rvRight = doReversePairs(nums, mid + 1, u);
        int rvCur = merge(nums, l, mid, u);
        return rvLeft + rvRight + rvCur;
    }
    
    private int merge(int[] nums, int l, int mid, int u)
    {
        // merge l...mid  and mid +1 ... u
        int[] copy = Arrays.copyOfRange(nums, l, u + 1);
        int i = l;
        int j = mid + 1;
        int pc = 0;
        int rv = 0;
        
        // O(first half + second half) way to get all the pairs! if certain i > 2*j, i+1 must do so too...
        for (int k = l, m = mid + 1; k <= mid; k++)
        {
            while (m <= u && nums[k] > 2L * nums[m])
            {
                m++;
            }
            rv += m - (mid + 1);
        }
        while (i <= mid && j <= u)
        {
            if (nums[i] < nums[j])
            {
                copy[pc++] = nums[i++];
                
            }
            else
            {
                copy[pc++] = nums[j++];
            }
        }
        while (i <= mid)
        {
            copy[pc++] = nums[i++];
        }
        while (j <= u)
        {
            copy[pc++] = nums[j++];
        }
        for (int k = 0; k < copy.length; k++)
        {
            nums[l + k] = copy[k];
        }
        return rv;
    }
    
}
