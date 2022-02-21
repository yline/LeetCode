package com.test;

import java.util.HashSet;
import java.util.Set;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public int robotSim(int[] commands, int[][] obstacles)
    {
        int l1 = obstacles.length;
        Set<Integer> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles)
        {
            obstacleSet.add((obs[0] << 16) + obs[1]);
        }
        
        int dir = 0, maxLen = Integer.MIN_VALUE;
        int[] curPos = {0, 0};
        for (Integer command : commands)
        {
            if (command < 0)
                dir = updateCurDir(dir, command);
            else
            {
                curPos = updateCurPos(obstacleSet, curPos, dir, command);
                maxLen = Math.max(maxLen, (int)Math.pow(curPos[0], 2) + (int)Math.pow(curPos[1], 2));
            }
            
        }
        return maxLen;
    }
    
    private int[] updateCurPos(Set<Integer> obstacleSet, int[] curPos, int dir, int command)
    {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] next = new int[2];
        for (int i = 0; i < command; i++)
        {
            next[0] = curPos[0] + dirs[dir][0];
            next[1] = curPos[1] + dirs[dir][1];
            if (obstacleSet.contains((next[0] << 16) + next[1]))
            {
                break;
            }
            curPos[0] = next[0];
            curPos[1] = next[1];
        }
        
        return curPos;
    }
    
    private int updateCurDir(int dir, int command)
    {
        if (command == -1)
        {
            dir = (dir + 1) % 4;
        }
        else if (command == -2)
        {
            dir = (dir + 3) % 4;
        }
        return dir;
    }
}
