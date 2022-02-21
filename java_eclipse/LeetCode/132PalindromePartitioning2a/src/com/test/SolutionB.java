package com.test;

import java.util.Arrays;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public int minCut(String s)
    {
        if (s == null || s.length() < 2)
            return 0;
        
        int N = s.length();
        int C[] = new int[N];
        Arrays.fill(C, N - 1);
        
        char[] str = s.toCharArray();
        for (int l = 0; l < N; ++l)
        {
            updateCutForPalindrome(str, l, l, C, N); // 奇数
            updateCutForPalindrome(str, l, l + 1, C, N); // 偶数
        }
        
        return C[N - 1];
    }
    
    /**
     * @param str 字符串
     * @param s start
     * @param e end
     * @param C 最小值
     * @param N length
     */
    private void updateCutForPalindrome(char[] str, int s, int e, int[] C, int N)
    {
        while (s >= 0 && e < N && str[s] == str[e])
        {
            C[e] = Math.min(C[e], (s - 1 >= 0 ? C[s - 1] : -1) + 1);
            ++e;
            --s;
        }
    }
}
