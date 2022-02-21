package com.test.array;

import java.util.LinkedList;
import java.util.Queue;

import com.test.base.ArrayGraph;
import com.test.base.ArraySolution;

/**
 * .广度优先遍历算法 Breadth-first search（非递归）
 * @author YLine
 *
 * 2019年2月22日 下午3:08:16
 */
public class SolutionBFS implements ArraySolution
{
    
    @Override
    public Object[] traverse(ArrayGraph graph)
    {
        Queue<Integer> queue = new LinkedList<>(); // LinkedList实现了Queue接口 FIFO
        
        int deep = 0;
        
        int size = graph.getSize();
        Object[] objArray = new Object[size];
        
        // 这个循环是为了确保每个顶点都被遍历到[以防一次遍历无法到达终点]
        for (int i = 0; i < size; i++)
        {
            if (!graph.isVisited(i))
            {
                queue.add(i);
                objArray[deep] = graph.getValue(i); // 赋值
                deep++;
                
                while (!queue.isEmpty())
                {
                    int topValue = queue.remove();
                    for (int next : graph.getNextArray(topValue))
                    {
                        if (!graph.isVisited(next))
                        {
                            queue.add(next);
                            objArray[deep] = graph.getValue(next);
                            deep++;
                        }
                    }
                }
            }
        }
        return objArray;
    }
}
