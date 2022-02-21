package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.base.Solution;

/**
 * 
 * There are n cities connected by m flights.
 * Each fight starts from city u and arrives at v with a price w.
 * 
 * Now given all the cities and flights,
 * together with starting city src and the destination dst,
 * 
 * your task is to find the cheapest price from src to dst with up to k stops.
 * If there is no such route, output -1.
 * 
 * 最短加权距离，问题
 * 
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 * 
 * 直接dfs 执行时长，119ms
 * 
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA implements Solution
{
    private int[][] mFlights; // 不修改
    private HashMap<Integer, List<Integer>> mHashMap; // 不修改
    
    private int mDstIndex;
    
    @Override
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        if (src == dst)
        {
            return 0;
        }
        
        // 减少遍历次数存在
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < flights.length; i++)
        {
            List<Integer> destList = hashMap.get(flights[i][0]);
            if (null == destList)
            {
                destList = new ArrayList<>();
                destList.add(i);
                hashMap.put(flights[i][0], destList);
            }
            else
            {
                destList.add(i); // 更新数据
            }
        }
        
        this.mFlights = flights;
        this.mHashMap = hashMap;
        this.mDstIndex = dst;
        this.mMin = Integer.MAX_VALUE;
        
        dfs(src, 0, K);
        return mMin == Integer.MAX_VALUE ? -1 : mMin;
    }

    private int mMin;
    
    private void dfs(int from, int value, int restK)
    {
        List<Integer> indexList = mHashMap.get(from);
        if (null == indexList)
        {
            return;
        }
        
        for (Integer index : indexList)
        {
            int to = mFlights[index][1];
            int tempValue = value + mFlights[index][2];
            
            // 到达终点了
            if (to == mDstIndex)
            {
                mMin = Math.min(mMin, tempValue);
                continue;
            }
            
            // 次数使用完、已经大于最小值
            if (restK == 0 || tempValue >= mMin)
            {
                continue;
            }
            
            dfs(to, tempValue, restK - 1);
        }
    }
    
}
