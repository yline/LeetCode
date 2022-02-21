package com.test;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public boolean judgeCircle(String moves)
    {
        int[] cnt = new int[128];
        for (char c : moves.toCharArray())
        {
            cnt[c]++;
        }
        return cnt['L'] == cnt['R'] && cnt['U'] == cnt['D'];
    }
}
