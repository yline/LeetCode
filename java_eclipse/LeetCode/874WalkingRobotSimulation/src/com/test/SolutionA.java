package com.test;

import java.util.HashMap;
import java.util.HashSet;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    
    @Override
    public int robotSim(int[] commands, int[][] obstacles)
    {
        HashMap<Integer, HashSet<Integer>> xMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> yMap = new HashMap<>();
        
        for (int i = 0; i < obstacles.length; i++)
        {
            if (xMap.containsKey(obstacles[i][0])) // x
            {
                xMap.get(obstacles[i][0]).add(obstacles[i][1]);
            }
            else
            {
                xMap.put(obstacles[i][0], new HashSet<>());
                xMap.get(obstacles[i][0]).add(obstacles[i][1]);
            }
            
            if (yMap.containsKey(obstacles[i][1])) // y
            {
                yMap.get(obstacles[i][1]).add(obstacles[i][0]);
            }
            else
            {
                yMap.put(obstacles[i][1], new HashSet<>());
                yMap.get(obstacles[i][1]).add(obstacles[i][0]);
            }
        }
        
        int oritation = 0;
        
        int max = 0;
        int x = 0, y = 0; // 北为y轴方向，西为x轴方向
        for (int i = 0; i < commands.length; i++)
        {
            if (-2 == commands[i])
            {
                oritation = (oritation + 1) % 4;
            }
            else if (-1 == commands[i])
            {
                oritation = (oritation + 3) % 4;
            }
            else
            {
                switch (oritation)
                {
                    case 0: // 北
                        y = movePositive(y, commands[i], xMap.get(x));
                        break;
                    case 1: // 西
                        x = moveNagetive(x, commands[i], yMap.get(y));
                        break;
                    case 2: // 南 
                        y = moveNagetive(y, commands[i], xMap.get(x));
                        break;
                    case 3: // 东
                        x = movePositive(x, commands[i], yMap.get(y));
                        break;
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        
        return max;
    }
    
    private int movePositive(int start, int distance, HashSet<Integer> hashSet)
    {
        if (null == hashSet)
        {
            return start + distance;
        }
        else
        {
            int minDistance = distance;
            for (Integer integer : hashSet)
            {
                integer -= start;
                if (0 < integer && integer <= minDistance)
                {
                    minDistance = integer - 1;
                }
            }
            return start + minDistance;
        }
    }
    
    private int moveNagetive(int start, int distance, HashSet<Integer> hashSet)
    {
        if (null == hashSet)
        {
            return start - distance;
        }
        else
        {
            int minDistance = distance;
            for (Integer integer : hashSet)
            {
                integer -= start;
                if (-minDistance <= integer && integer < 0)
                {
                    minDistance = -integer - 1;
                }
            }
            return start - minDistance;
        }
    }
}
