package com.test.shortest;

import java.util.Arrays;
import java.util.Iterator;

import com.test.shortest.PathGraph.Edge;
import com.test.shortest.PathGraph.Vertex;

/**
 * Dijkstra 算法 -- 单源最短路径算法（可以看做是一个动态规划）
 * 
 * 参考：https://time.geekbang.org/column/article/76468
 * 
 * 这个思路简单，实现涉及到数据结构的切换，有点恶心
 * 
 * @author YLine
 *
 * 2019年4月28日 下午5:22:11
 */
public class Dijkstra
{
    public static void shortest(PathGraph graph, int start, int end)
    {
        // 入口校验，这里省略【毕竟不是做产品】
        
        CustomHeap minHeap = new CustomHeap();
        Vertex startVertex = graph.getVertex(start);
        Vertex endVertex = graph.getVertex(end);

        // 进行首个初始化
        minHeap.add(new Result(0, startVertex, null));
        
        // 全部默认未访问
        boolean[] visitedArray = new boolean[graph.getVertexSize()];
        Arrays.fill(visitedArray, false);
        
        // 小顶堆
        Result result = null;
        while (!minHeap.isEmpty())
        {
            Result currentNode = minHeap.poll();
            Vertex currentVertex = currentNode.currentVertex;
            
            // 如果抛出的已经达到终点了，则不用再进行循环了
            if (currentVertex == endVertex)
            {
                result = currentNode;
                break;
            }
            
            for (Iterator<Edge> iterator = currentVertex.iterator(); iterator.hasNext();)
            {
                Edge edge = iterator.next();
                Vertex nextVertex = edge.getEndVertex();
                
                int nextIndex = graph.indexOf(nextVertex);
                if (nextIndex != -1)
                {
                    if (!visitedArray[nextIndex])
                    {
                        // 未访问过时
                        int newValue = currentNode.value + edge.getWeight();
                        minHeap.add(new Result(newValue, nextVertex, currentNode));
                        
                        visitedArray[nextIndex] = true;
                    }
                    else
                    {
                        // 已访问过时，修改数据即可
                        int newValue = currentNode.value + edge.getWeight();
                        minHeap.update(nextVertex, newValue, currentNode);
                    }
                }
            }
        }
        
        // 打印结果，和，路径（从后往前）
        if (null == result)
        {
            System.err.println("result is null, 程序异常");
        }
        else
        {
            Result temp = result;
            StringBuilder sBuilder = new StringBuilder();
            while (null != temp)
            {
                sBuilder.append(temp.currentVertex.getId());
                sBuilder.append(" -> ");
                
                temp = temp.preResult;
            }
            
            sBuilder.append("result = ");
            sBuilder.append(result.value);
            
            System.out.println(sBuilder.toString());
        }
    }
    
    /**
     * 自定义一个堆，实现更新数据【否则，无法依据内容更新某条数据】
     */
    public static class CustomHeap extends MinHeap<Result>
    {
        /**
         * .更新某一条数据
         * .规则：
         * 1, 依据当前节点，找到对应的Result
         * 2, 判断，如果新的值 大于等于  旧的Result，则不用处理
         * 3，判断，如果新的值 小于 旧的Result，则更新数据，然后进行堆化
         */
        public void update(Vertex currentVertex, int newValue, Result preResult)
        {
            int currentIndex = -1;
            Result currentResult = null;
            for (int i = 1; i < getSize(); i++)
            {
                if (getData(i).currentVertex == currentVertex)
                {
                    currentIndex = i;
                    currentResult = getData(i);
                    break;
                }
            }
            
            // 依据规则，进行处理
            if (null != currentResult && currentResult.value > newValue)
            {
                currentResult.setValue(newValue);
                
                // 更新两层，preResult
                Result oldPreResult = currentResult.preResult;
                preResult.setPreResult(oldPreResult);
                currentResult.setPreResult(preResult);
                
                heapifyUp(currentIndex);
            }
        }
    }
    
    /**
     * 选择的节点
     */
    public static class Result implements Comparable<Result>
    {
        private int value; // 表示，起始顶点到当前顶点的最短路径
        
        private Vertex currentVertex; // 表示，当前顶点
        
        private Result preResult; // 表示，最短路径对应的前一个顶点【可能是一个链表】
        
        public Result(int val, Vertex vertex, Result preResult)
        {
            this.value = val;
            this.currentVertex = vertex;
            this.preResult = preResult;
        }
        
        @Override
        public int compareTo(Result o)
        {
            if (null != o)
            {
                return (value < o.value ? -1 : 1);
            }
            return 0;
        }
        
        public int getValue()
        {
            return value;
        }
        
        public void setValue(int value)
        {
            this.value = value;
        }
        
        public void setPreResult(Result preResult)
        {
            this.preResult = preResult;
        }
        
        public Result getPreResult()
        {
            return preResult;
        }
    }
    
    public static PathGraph createGraph()
    {
        PathGraph graph = new PathGraph();
        
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 15);
        
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 3, 2);
        
        graph.addEdge(2, 5, 5);
        
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 12);
        
        graph.addEdge(4, 5, 10);
        
        return graph;
    }
}
