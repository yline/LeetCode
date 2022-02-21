package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.test.base.Solution;

/**
 * BFS，遍历所有的可能
 * 
 * 使用 int[1<<N][N]，做重复计算过滤【重点】
 * 
 * x为：state，当前经过的点的位置，及，个数
 * y为：head，当前的点的位置
 * 
 * @author YLine
 *
 * 2019年9月12日 下午3:23:13
 */
public class SolutionB implements Solution
{
    @Override
    public int shortestPathLength(int[][] graph)
    {
        final int N = graph.length;
        final int endState = (1 << N) - 1;
        
        Queue<State> queue = new LinkedList<>();
        int[][] dist = new int[1 << N][N];
        for (int[] row : dist)
        {
            Arrays.fill(row, N * N);
        }
        
        for (int x = 0; x < N; ++x)
        {
            queue.offer(new State(1 << x, x));
            dist[1 << x][x] = 0;
        }
        
        while (!queue.isEmpty())
        {
            State node = queue.poll();
            int d = dist[node.state][node.head];
            if (node.state == endState)
            {
                return d;
            }
            
            for (int child : graph[node.head])
            {
                int cover2 = node.state | (1 << child);
                if (d + 1 < dist[cover2][child]) // 当 state重复、index相同时，step较多的直接排除
                {
                    dist[cover2][child] = d + 1;
                    queue.offer(new State(cover2, child));
                    
                }
            }
        }
        
        throw null;
    }
    
    private static class State
    {
        private int state; // 2^0 + 2^1 ... + 2^n, 用来表示0-n，是否存在
        
        private int head; // 当前的 index
        
        State(int c, int h)
        {
            state = c;
            head = h;
        }
    }
}
