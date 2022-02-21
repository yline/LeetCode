package com.test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

import com.test.base.Solution;

/**
 * 构建一个图，超时
 * 
 * @author YLine
 *
 * 2019年10月15日 下午9:11:53
 */
public class SolutionA implements Solution
{
    @Override
    public int numBusesToDestination(int[][] routes, int S, int T)
    {
        if (S == T)
        {
            return 0;
        }
        
        // 构造点时间的图，距离为1的为相互关联
        Graph graph = new Graph();
        for (int i = 0; i < routes.length; i++)
        {
            graph.buildByRoutes(routes[i]);
        }
        
        // bfs直接遍历
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(S);
        
        // 缓存，key - value的距离
        HashMap<Integer, Integer> cacheMap = new HashMap<>();
        cacheMap.put(S, 0);
        
        while (!queue.isEmpty())
        {
            Integer stop = queue.pollFirst();
            int step = cacheMap.get(stop);
            HashSet<Integer> nextStopSet = graph.get(stop);
            
            // 空校验
            if (null == nextStopSet || nextStopSet.isEmpty())
            {
                continue;
            }
            
            // 已经找到
            if (nextStopSet.contains(T))
            {
                return step + 1;
            }
            
            // 加入下一个循环
            for (Integer nextStop : nextStopSet)
            {
                // 已经添加过，则不重复添加
                if (cacheMap.containsKey(nextStop))
                {
                    continue;
                }
                
                cacheMap.put(nextStop, step + 1);
                queue.add(nextStop);
            }
        }

        return -1;
    }
    
    public static class Graph
    {
        // 建立点 到 其他点的映射（自带防重）
        private HashMap<Integer, HashSet<Integer>> map;
        
        public Graph()
        {
            map = new HashMap<>();
        }
        
        public HashSet<Integer> get(int key)
        {
            return map.get(key);
        }
        
        public void buildByRoutes(int[] array)
        {
            if (null == array || array.length < 2)
            {
                return;
            }
            
            for (int i = 0; i < array.length; i++)
            {
                for (int j = i + 1; j < array.length; j++)
                {
                    add(array[i], array[j]);
                }
            }
        }
        
        private void add(int stopA, int stopB)
        {
            HashSet<Integer> aSet = map.get(stopA);
            if (null == aSet)
            {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(stopB);
                map.put(stopA, newSet);
            }
            else
            {
                aSet.add(stopB);
            }
            
            HashSet<Integer> bSet = map.get(stopB);
            if (null == bSet)
            {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(stopA);
                map.put(stopB, newSet);
            }
            else
            {
                bSet.add(stopA);
            }
        }
    }
}
