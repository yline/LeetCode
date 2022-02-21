package com.test;

import java.util.ArrayList;
import java.util.List;

public class SolutionA
{
    
    // 基础理论：
    // (a*2+b) % 5 = (a*2)%5 + (b)%5
    
    public List<Boolean> prefixesDivBy5(int[] A)
    {
        if (null == A || A.length == 0)
        {
            return new ArrayList<>();
        }
        
        ArrayList<Boolean> result = new ArrayList<>(A.length);
        
        // 计算第一个值
        int value = A[0];
        result.add(0, value == 0);
        
        // 从第二个开始遍历
        for (int i = 1; i < A.length; i++)
        {
            value = (value << 1) + A[i]; // 以"前一个"为结果，去推出下一个
            value %= 5;
            
            result.add(i, value == 0);
        }
        
        return result;
    }
}
