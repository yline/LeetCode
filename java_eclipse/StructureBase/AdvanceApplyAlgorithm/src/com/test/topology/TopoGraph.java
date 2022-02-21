package com.test.topology;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 拓扑排序所需要的图
 * @author YLine
 *
 * 2019年4月28日 上午10:40:11
 */
public class TopoGraph
{
    /**
     * 创建一个图，并且设置默认数据
     */
    public static TopoGraph createGraph()
    {
        TopoGraph graph = new TopoGraph();
        
        /**
         * A1 -> A2 -> A5
         * A3 -> A4 -> A5
         */
        graph.addVertex("A1");
        graph.addVertex("A2");
        graph.addVertex("A3");
        graph.addVertex("A4");
        graph.addVertex("A5");
        
        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        /**
         * B1 -> B2 -> B3
         * B1 -> B2 -> B4
         * B1 -> B2 -> B5
         */
        graph.addVertex("B1");
        graph.addVertex("B2");
        graph.addVertex("B3");
        graph.addVertex("B4");
        graph.addVertex("B5");
        
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(6, 9);
        
        /**
         * C1 -> C5
         * C1 -> C2 -> C3 -> C4 -> C5
         */
        graph.addVertex("C1");
        graph.addVertex("C2");
        graph.addVertex("C3");
        graph.addVertex("C4");
        graph.addVertex("C5");
        
        graph.addEdge(10, 14);
        
        graph.addEdge(10, 11);
        graph.addEdge(11, 12);
        graph.addEdge(12, 13);
        graph.addEdge(13, 14);
        
        /**
         * D1 -> D3 -> D5
         * D1 -> D4 -> D5
         * D2 -> D3 -> D5
         * D2 -> D4 -> D5
         */
        graph.addVertex("D1");
        graph.addVertex("D2");
        graph.addVertex("D3");
        graph.addVertex("D4");
        graph.addVertex("D5");
        
        graph.addEdge(15, 17);
        graph.addEdge(15, 18);
        graph.addEdge(16, 17);
        graph.addEdge(16, 18);

        graph.addEdge(17, 19);
        graph.addEdge(18, 19);
        
        return graph;
    }
    
    private List<Node> nodeArray; // 顶点对应的列表
    
    public TopoGraph()
    {
        this.nodeArray = new ArrayList<>();
    }
    
    /**
     * 添加顶点
     */
    public void addVertex(String value)
    {
        nodeArray.add(new Node(value));
    }
    
    /**
     * 添加边
     * start -> end
     * start为父类，end为子类
     */
    public void addEdge(int start, int end)
    {
        checkValid(start);
        checkValid(end);
        
        nodeArray.get(start).addChild(nodeArray.get(end));
    }
    
    /**
     * 返回数组大小
     */
    public int getSize()
    {
        return nodeArray.size();
    }
    
    /**
     * 返回某个节点
     */
    public Node getVertex(int index)
    {
        checkValid(index);
        return nodeArray.get(index);
    }
    
    /**
     * 依据节点，返回某个index
     * @param node
     * @return
     */
    public int getIndexByNode(Node node)
    {
        return nodeArray.indexOf(node);
    }
    
    private void checkValid(int index)
    {
        if (index < 0 || index >= nodeArray.size())
        {
            throw new IllegalAccessError("index OutOfBoundException, index = " + index);
        }
    }

    public static class Node
    {
        private String value; // 自身内容（父类）
        
        private List<Node> childList; // 多个 子类
        
        public Node(String value)
        {
            this.value = value;
            this.childList = new LinkedList<>();
        }
        
        /**
         * 添加子类
         * @param child
         */
        public void addChild(Node child)
        {
            childList.add(child);
        }
        
        /**
         * 是否包含某个子类
         * @param child
         * @return
         */
        public boolean contain(Node child)
        {
            return childList.contains(child);
        }
        
        /**
         * 返回所有的子节点
         * @return
         */
        public List<Node> getChildList()
        {
            return childList;
        }
        
        public String getValue()
        {
            return value;
        }
    }
}
