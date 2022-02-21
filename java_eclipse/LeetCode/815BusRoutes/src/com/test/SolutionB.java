package com.test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

import com.test.base.Solution;

/**
 * 构建一个倒插排序
 * 
 * 通过
 * 
 * @author YLine
 *
 * 2019年10月16日 上午10:48:29
 */
public class SolutionB implements Solution
{
    
    @Override
    public int numBusesToDestination(int[][] routes, int S, int T)
    {
        if (S == T)
        {
            return 0;
        }
        
        // 构建倒插排序的结构
        Inversion inversion = new Inversion();
        inversion.build(routes);
        
        // bfs直接遍历
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(S);

        // 访问过的站点
        HashSet<Integer> indexCache = new HashSet<>();
        
        // 访问过的节点，同时记录一下Step
        HashMap<Integer, Integer> stopCache = new HashMap<>();
        stopCache.put(S, 0);
        
        while (!queue.isEmpty())
        {
            Integer stop = queue.pollFirst();
            int step = stopCache.get(stop);
            
            // 下一个站点的集合
            HashSet<Integer> nextStopSet = new HashSet<>();
            
            for (Integer index : inversion.get(stop))
            {
                // 已经处理过的，就不再处理
                if (indexCache.contains(index))
                {
                    continue;
                }
                
                indexCache.add(index);
                for (int j = 0; j < routes[index].length; j++)
                {
                    nextStopSet.add(routes[index][j]);
                }
            }
            
            // 空校验
            if (nextStopSet.isEmpty())
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
                if (stopCache.containsKey(nextStop))
                {
                    continue;
                }
                
                stopCache.put(nextStop, step + 1);
                queue.add(nextStop);
            }
        }
        
        return -1;
    }
    
    public static class Inversion
    {
        // 建立点 到 下标的映射（自带去重）
        private HashMap<Integer, HashSet<Integer>> map;
        
        public Inversion()
        {
            map = new HashMap<>();
        }
        
        public HashSet<Integer> get(int value)
        {
            return map.get(value);
        }
        
        /**
         * .构建倒插
         */
        public void build(int[][] routes)
        {
            if (null == routes || routes.length == 0)
            {
                return;
            }
            
            for (int index = 0; index < routes.length; index++)
            {
                for (int j = 0; j < routes[index].length; j++)
                {
                    add(index, routes[index][j]);
                }
            }
        }
        
        private void add(int index, int value)
        {
            HashSet<Integer> indexSet = map.get(value);
            if (null == indexSet)
            {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(index);
                map.put(value, newSet);
            }
            else
            {
                indexSet.add(index);
            }
        }
    }
}
