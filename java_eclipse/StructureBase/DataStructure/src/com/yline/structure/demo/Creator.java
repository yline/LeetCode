package com.yline.structure.demo;

import com.yline.structure.Graph;

/**
 * 创建各种数据结构的案例
 * @author YLine
 *
 * 2019年4月29日 上午9:59:18
 */
public class Creator
{
    public static Graph createGraph()
    {
        Graph graph = new Graph();
        
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
