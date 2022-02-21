package com.test;

import java.util.Arrays;
import java.util.Comparator;

import com.test.base.Solution;

/**
 * 先排序，再按区分
 * @author YLine
 *
 * 2018年12月26日 下午5:00:35
 */
public class SolutionA implements Solution
{
    @Override
    public int maxChunksToSorted(int[] arr)
    {
        Point[] arrayPoint = new Point[arr.length];
        for (int i = 0; i < arrayPoint.length; i++)
        {
            arrayPoint[i] = new Point(i, arr[i]);
        }
        
        // 排序是稳定的
        Arrays.sort(arrayPoint, new Comparator<Point>()
        {
            @Override
            public int compare(Point point1, Point point2)
            {
                return point1.value - point2.value;
            }
        });
        
        // 划分块
        int maxChunk = 0;
        
        int rest = 0;
        for (int i = 0; i < arrayPoint.length; i++)
        {
            rest = Math.max(rest - 1, (arrayPoint[i].index - i));
            if (rest == 0)
            {
                maxChunk++;
            }
        }
        return maxChunk;
    }
    
    private static class Point
    {
        private int index;
        
        private int value;
        
        private Point(int index, int value)
        {
            super();
            this.index = index;
            this.value = value;
        }
    }
}
