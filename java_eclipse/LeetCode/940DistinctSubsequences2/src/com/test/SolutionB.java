package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 通过SolutionA，找规律得到以下递推方程式
 * 
 * 当a[x]与前面的值没有相等时，f(x) = 1 + f(1) + f(2) + ... + f(x-1);
 * 当a[x]与a[i]相等时，i为最后一个相等的，f(x) = f(i+1) + ... + f(x-1);
 * 
 * @author YLine
 *
 * 2019年5月8日 上午10:18:31
 */
public class SolutionB implements Solution
{
    
    @Override
    public int distinctSubseqII(String S)
    {
        int[] checkArray = new int[26]; // 这个用于校验是否相等，若相等，则返回最后一个index
        Arrays.fill(checkArray, -1);
        
        // 这个用于储存每一个的结果
        int[] resultArray = new int[S.length()];

        // 遍历获取每一个值对应的结果
        for (int i = 0; i < S.length(); i++)
        {
            char val = S.charAt(i);
            int lastIndex = checkArray[val - 'a'];
            
            if (lastIndex == -1)
            {
                resultArray[i] = 1 + sum(resultArray, 0, i);
            }
            else
            {
                resultArray[i] = sum(resultArray, lastIndex, i);
            }
            
            // 给check更新值
            checkArray[val - 'a'] = i;
        }
        
        System.out.println(Arrays.toString(resultArray));
        
        return sum(resultArray, 0, resultArray.length);
    }
    
    private int sum(int[] array, int start, int end)
    {
        long result = 0;
        for (int i = start; i < end; i++)
        {
            result += array[i];
        }
        
        return (int)(result % 1000000007);
    }
}
