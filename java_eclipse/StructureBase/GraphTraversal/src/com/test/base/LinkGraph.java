package com.test.base;

import java.util.ArrayList;
import java.util.List;

/**
 * .链表 -> 图
 * .使用链表实现图
 * .无向图
 * 
 * @author YLine
 *
 * 2019年3月22日 下午1:57:41
 */
public class LinkGraph
{
    public static LinkGraph createGraph()
    {
        LinkGraph graph = new LinkGraph(6);
        attachData(graph);
        return graph;
    }
    
    private static void attachData(LinkGraph graph)
    {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
    }
    
    private int capacity; // 容量
    
    /** 实际向量大小 */
    private int vertexSize;
    
    private Node dataArray[];
    
    public LinkGraph(int capacity)
    {
        this.capacity = capacity;
        this.dataArray = new Node[capacity];
    }
    
    public int getSize()
    {
        return vertexSize;
    }
    
    public Node getValue(int index)
    {
        return dataArray[index];
    }
    
    /**
     * .添加顶点
     * @param val 点内容
     */
    private void addVertex(String val)
    {
        checkValid(vertexSize);
        
        if (null == dataArray[vertexSize])
        {
            dataArray[vertexSize] = new Node(vertexSize, val);
            vertexSize++;
        }
    }
    
    /**
     * .添加边[方向][第一个位置 指向 第二个位置，有则返回true]
     * @param start 第一个点位置
     * @param end 第二个点位置
     */
    private void addEdge(int start, int end)
    {
        assert (start >= 0 && start < capacity);
        assert (end >= 0 && end < capacity);
        assert (start != end);
        
        dataArray[start].addEdge(dataArray[end]);
        dataArray[end].addEdge(dataArray[start]);
    }
    
    private void checkValid(int index)
    {
        if (index < 0 || index >= capacity)
        {
            throw new IllegalArgumentException("index is error");
        }
    }
    
    public static class Node
    {
        private int index; // 节点位置
        
        private String value; // 节点内容
        
        private List<Node> dataList; // 链表内容
        
        public Node(int index, String val)
        {
            this.index = index;
            this.value = val;
            this.dataList = new ArrayList<>();
        }
        
        public void addEdge(Node next)
        {
            dataList.add(next);
        }
        
        public List<Node> getDataList()
        {
            return dataList;
        }
        
        public int getPosition()
        {
            return this.index;
        }
        
        public String getValue()
        {
            return this.value;
        }
    }
}
