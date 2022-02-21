package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.test.base.Solution;

/**
 * 时间复杂度：n*log(n) + n
 * @author YLine
 *
 * 2019年5月6日 上午9:17:42
 */
public class SolutionA implements Solution
{
    @Override
    public int[][] merge(int[][] intervals)
    {
        if (intervals.length < 2)
        {
            return intervals;
        }
        
        // 先排序，时间复杂度 = n*log(n)
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });
        
        // 排序后的内容
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < intervals.length; i++)
        {
            sBuilder.append(Arrays.toString(intervals[i]));
            sBuilder.append(',');
        }
        System.out.println(sBuilder.toString());
        
        // 合并
        List<int[]> temp = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] <= end)
            {
                // 融合
                end = Math.max(end, intervals[i][1]);
            }
            else
            {
                // 添加
                temp.add(new int[] {start, end});
                // 再次初始化
                {
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
        }
        // 最后一个，添加
        temp.add(new int[] {start, end});
        
        // 合并后的内容
        sBuilder = new StringBuilder();
        for (int i = 0; i < temp.size(); i++)
        {
            sBuilder.append(Arrays.toString(temp.get(i)));
            sBuilder.append(',');
        }
        System.out.println(sBuilder.toString());
        
        
        // 最后完成赋值
        int[][] result = new int[temp.size()][];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = temp.get(i);
        }
        return result;
    }
    
}
