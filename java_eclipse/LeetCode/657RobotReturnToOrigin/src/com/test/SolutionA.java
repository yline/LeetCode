package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public boolean judgeCircle(String moves)
    {
        int x = 0, y = 0;
        
        for (int i = 0; i < moves.length(); i++)
        {
            if (moves.charAt(i) == 'R')
            {
                x += 1;
                continue;
            }
            
            if (moves.charAt(i) == 'L')
            {
                x -= 1;
                continue;
            }
            
            y += moves.charAt(i) == 'U' ? 1 : -1;
        }
        
        return (x == 0 && y == 0);
    }
}
