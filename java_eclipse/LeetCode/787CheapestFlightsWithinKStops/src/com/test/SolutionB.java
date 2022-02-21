package com.test;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.test.base.Solution;

/**
 * 利用优先级队列，将数值较小的，优先排出；bfs的思路
 * 
 * 执行时长：2ms
 * 
 * @author YLine
 *
 * 2019年6月19日 下午6:21:08
 */
public class SolutionB implements Solution
{
    class City implements Comparable<City>
    {
        int id;
        
        int costFromSrc;
        
        int stopFromSrc;
        
        public City(int id, int costFromSrc, int stopFromSrc)
        {
            this.id = id;
            this.costFromSrc = costFromSrc;
            this.stopFromSrc = stopFromSrc;
        }
        
        @Override
        public int compareTo(City c)
        {
            return this.costFromSrc - c.costFromSrc;
        }
    }
    
    @Override
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[][] srcToDist = new int[n][n];//相当于是用adjacent matrix来表示Graph
        for (int i = 0; i < flights.length; i++)
        {
            int start = flights[i][0];
            int dist = flights[i][1];
            srcToDist[start][dist] = flights[i][2];
        }
        
        PriorityQueue<City> minHeap = new PriorityQueue<>();
        minHeap.offer(new City(src, 0, 0));
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        stop[src] = 0;
        
        while (!minHeap.isEmpty())
        {
            City curCity = minHeap.poll();
            if (curCity.id == dst)
            {
                return curCity.costFromSrc;
            }
            if (curCity.stopFromSrc == K + 1)
            {
                continue;
            }
            
            //我觉得他怎么找child这块儿比较特殊
            int[] nexts = srcToDist[curCity.id];
            for (int i = 0; i < n; i++)
            {
                if (nexts[i] != 0)
                { //!!!!这个就是adjancent matrix的缺点, 很稀疏
                    int newCost = curCity.costFromSrc + nexts[i];
                    int newStop = curCity.stopFromSrc + 1;
                    if (newCost < cost[i])
                    {
                        minHeap.offer(new City(i, newCost, newStop));
                        cost[i] = newCost;
                    }
                    else if (newStop < stop[i])
                    {
                        minHeap.offer(new City(i, newCost, newStop));
                        stop[i] = newStop;
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
        
    }
}
