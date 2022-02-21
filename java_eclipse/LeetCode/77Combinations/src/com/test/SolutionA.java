package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA
{
    private int mSize;
    
    public List<List<Integer>> combine(int n, int k)
    {
        boolean[] stateArray = new boolean[n + 1];
        mSize = k;
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, stateArray, k, 1);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, boolean[] stateArray, int k, int start)
    {
        if (k == 0)
        {
            List<Integer> temp = new ArrayList<>(mSize);
            for (int i = 1; i < stateArray.length; i++)
            {
                if (stateArray[i])
                {
                    temp.add(i);
                }
            }
            result.add(temp);
            return;
        }
        
        for (int i = start; i < stateArray.length; i++)
        {
            if (!stateArray[i])
            {
                stateArray[i] = true;
                dfs(result, stateArray, k - 1, i + 1);
                stateArray[i] = false;
            }
        }
    }
}
