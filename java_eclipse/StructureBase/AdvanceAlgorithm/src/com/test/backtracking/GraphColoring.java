package com.test.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 图的着色
 * 给定无向连通图G和m种不同的颜色
 * 用这些颜色为图G的各顶点着色，每个顶点着一种颜色。是否有一种着色法使G中每条边的2个顶点着不同颜色
 * 
 * 输入：无向图,m
 * 输出：如果能，则输出方案
 * 
 * 参考：https://blog.csdn.net/kevin_cyj/article/details/50385575
 * 
 * @author YLine
 *
 * 2019年4月15日 下午1:59:51
 */
public class GraphColoring
{
    /**
     * 创建一个无向连通图，每个节点都联通
     * @return
     */
    public static Graph createGraph(String... values)
    {
        Graph graph = new Graph();
        // 添加节点
        for (String val : values)
        {
            graph.addVertex(val);
        }
        
        // 添加边
        for (int i = 0; i < values.length; i++)
        {
            for (int j = i + 1; j < values.length; j++)
            {
                graph.addEdge(i, j);
            }
        }
        
        return graph;
    }
    
    /**
     * 给无向图，着色
     * @param m 颜色种类
     * @param values 所有的数据
     * @return 返回所有的数量【并且，颜色会清零】
     */
    public int coloring(Graph graph, int m)
    {
        colorNode(graph, 0, m);
        return value;
    }
    
    private int value = -1;
    
    public int getValue()
    {
        return value + 1;
    }
    
    public void resetValue()
    {
        value = -1;
    }
    
    /**
     * 这个并不是回溯法；只是普通的递归；
     * 如果是回溯，则修改实现方案。但整体类似
     * 
     * 该方法，只要有方案就结束了
     * @param graph 图
     * @param index 开始位置0
     * @param m 颜色总数
     */
    private void colorNode(Graph graph, int index, int m)
    {
        if (index == graph.getSize())
        {
            // 打印当前的染色方案
            value++;
            print(graph, value);
            return;
        }
        
        Node node = graph.getVertex(index);
        
        // 获取可能的染色，颜色
        int nowColor = -1;
        for (int i = 0; i < m; i++)
        {
            if (node.isColorValid(i))
            {
                nowColor = i;
                break;
            }
        }
        
        // 该节点，没有合适的颜色，代表失败
        if (nowColor != -1)
        {
            node.setColor(nowColor);
            colorNode(graph, index + 1, m);
            node.setColor(-1);
        }
    }
    
    public static void print(Graph graph, int index)
    {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < graph.getSize(); i++)
        {
            Node node = graph.getVertex(i);
            sBuilder.append(String.format("(%d-%s, color:%d) ", i, node.value, node.color));
        }
        System.out.println(sBuilder.toString() + ", index = " + index);
    }
    
    public static class Graph
    {
        private List<Node> dataList;
        
        public Graph()
        {
            this.dataList = new ArrayList<>();
        }
        
        /**
         * 添加节点
         * @param val
         */
        public void addVertex(String val)
        {
            dataList.add(new Node(val));
        }
        
        /**
         * 添加边
         */
        public void addEdge(int start, int end)
        {
            checkValid(start);
            checkValid(end);
            
            dataList.get(start).addNeighbor(dataList.get(end));
            dataList.get(end).addNeighbor(dataList.get(start));
        }
        
        private void checkValid(int index)
        {
            if (index < 0 || index >= dataList.size())
            {
                throw new IllegalArgumentException("index is error");
            }
        }
        
        /**
         * 返回某个节点
         * @param index 节点index
         * @return 节点
         */
        public Node getVertex(int index)
        {
            checkValid(index);
            return dataList.get(index);
        }
        
        /**
         * 返回节点总数
         * @return
         */
        public int getSize()
        {
            return dataList.size();
        }
    }
    
    public static class Node
    {
        private String value;
        
        private int color;
        
        private HashSet<Node> hashSet;
        
        public Node(String value)
        {
            this.value = value;
            this.color = -1;
            this.hashSet = new HashSet<>();
        }
        
        /**
         * 获取节点的值
         * @return 节点值
         */
        public String getValue()
        {
            return value;
        }
        
        /**
         * 添加的连接点
         * @param node 节点
         */
        public void addNeighbor(Node node)
        {
            if (!hashSet.contains(node))
            {
                hashSet.add(node);
            }
        }
        
        /**
         * 查询某个颜色，是否在邻居中，出现过
         * @param color 颜色
         * @return true 合法(未出现过)
         */
        public boolean isColorValid(int color)
        {
            boolean isExist = false;
            for (Node node : hashSet)
            {
                if (node.color == color)
                {
                    isExist = true;
                }
            }
            return !isExist;
        }
        
        /**
         * 添加颜色
         * @param color 颜色值
         * @return 是否添加成功
         */
        public void setColor(int color)
        {
            this.color = color;
        }
        
        /**
         * 获取所有的，未着色的，连接点
         * @return 未着色的连接点
         */
        public List<Node> getNoColorNeighborList()
        {
            List<Node> nodeList = new ArrayList<>();
            for (Node node : hashSet)
            {
                if (node.color == -1)
                {
                    nodeList.add(node);
                }
            }
            return nodeList;
        }
    }
}
