package com.test;

import java.util.Arrays;

/**
 * Suppose you have N integers from 1 to N. 
 * 有1-N个数字
 * 
 * We define a beautiful arrangement as an array that is constructed by these N numbers successfully 
 * if one of the following is true for the ith position (1 <= i <= N) in this array:
 * 如果，满足以下条件之一，就可以算好的队列
 * 
 * 1) The number at the ith position is divisible by i.
 * array[i] % i == 0
 * 
 * 2) i is divisible by the number at the ith position.
 * i % array[i] == 0
 * 
 * N is a positive integer and will not exceed 15.
 * N <= 15
 * 
 * 思路：
 * 直接解法：没有好的思路，只能递归遍历
 * 间接解法：通过自己的计算，等到结果对应的数组，直接返回一个数组中的数字即可
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA
{
    /**
     * 这个方法，是将下面的函数，运行一次，看结果，得到的
     * @param N
     * @return
     */
    public int countArrangement2(int N)
    {
        int[] result = {0, 1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        return result[N];
    }
    
    public int countArrangement(int N)
    {
        // 当前值是否使用过
        boolean[] valueArray = new boolean[N];
        Arrays.fill(valueArray, false);
        
        result = 0;
        dfs(valueArray, 0);
        
        System.out.println(N + " count = " + result);
        
        return result;
    }
    
    private int result;
    
    private void dfs(boolean[] valueArray, int deep)
    {
        // 符合要求
        if (deep == valueArray.length)
        {
            result++;
        }
        
        for (int i = 0; i < valueArray.length; i++)
        {
            if (!valueArray[i] && isMatch(deep, i))
            {
                valueArray[i] = true;
                dfs(valueArray, deep + 1);
                valueArray[i] = false;
            }
        }
    }
    
    private boolean isMatch(int key, int value)
    {
        key++;
        value++;
        return key % value == 0 || value % key == 0;
    }
}
