package com.test;

import java.util.ArrayDeque;

import com.test.base.Solution;

/**
 * 直接，每个都bfs遍历
 * 运行超时，需要优化
 * 
 * 优化操作：SolutionB
 * 
 * @author YLine
 *
 * 2019年9月12日 上午10:01:57
 */
public class SolutionA implements Solution
{
    @Override
    public int shortestPathLength(int[][] graph)
    {
        if (null == graph || graph.length == 0 || graph[0].length == 0)
        {
            return 0;
        }
        
        ArrayDeque<VisitNode> nodeQueue = new ArrayDeque<>();
        
        int minStep = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++)
        {
            VisitNode tempNode = new VisitNode(graph.length);
            tempNode.addLast(i);
            nodeQueue.add(tempNode);
            
            int thisStep = bfs(graph, nodeQueue, minStep);
            nodeQueue.clear();
            minStep = Math.min(minStep, thisStep);
        }
        
        return minStep;
    }
    
    private int bfs(int[][] graph, ArrayDeque<VisitNode> nodeQueue, int minStep)
    {
        while (!nodeQueue.isEmpty())
        {
            VisitNode visitNode = nodeQueue.pollFirst();
            if (visitNode.step >= minStep)
            {
                return Integer.MAX_VALUE;
            }
            
            int[] nextArray = graph[visitNode.current];
            for (int i = nextArray.length - 1; i >= 0; i--)
            {
                VisitNode newNode = (i != 0 ? visitNode.copy() : visitNode); // 节省内存
                
                newNode.addLast(nextArray[i]);
                if (newNode.isEnd())
                {
                    return newNode.step - 1;
                }
                
                nodeQueue.addLast(newNode);
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    private static class VisitNode
    {
        private int current; // 当前的位置
        
        private int step; // 节点总数

        private int state; // 访问过的点的状态
        
        private final int length;
        
        private final int endState;
        
        private VisitNode(int length)
        {
            this.length = length;
            this.endState = (1 << length) - 1;
            
            this.step = 0;
        }
        
        private VisitNode(int length, int endState, int state, int current, int step)
        {
            this.length = length;
            this.endState = endState;
            
            this.state = state;
            this.current = current;
            
            this.step = step;
        }

        private VisitNode copy()
        {
            return new VisitNode(length, endState, state, current, step);
        }
        
        private void addLast(int index)
        {
            this.current = index;
            this.step++;
            
            state |= (1 << index);
        }
        
        private boolean isEnd()
        {
            return state == endState;
        }
    }
}
