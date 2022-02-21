package com.test.base;

import java.util.Arrays;

/**
 * .数据 -> 图
 * .被坑了，应该用链表实现图的，用数组实现，麻烦又功能弱
 * @author YLine
 *
 * 2019年2月22日 下午1:53:14
 */
public class ArrayGraph
{
    public static ArrayGraph createUndirectGraph(int capacity)
    {
        ArrayGraph graph = new ArrayGraph(UNDIRECTED_GRAPH, capacity);
        attachData(graph);
        return graph;
    }
    
    public static ArrayGraph createDirectGraph(int capacity)
    {
        ArrayGraph graph = new ArrayGraph(DIRECTED_GRAPH, capacity);
        attachData(graph);
        return graph;
    }
    
    private static void attachData(ArrayGraph graph)
    {
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
    }
    
    private static final boolean UNDIRECTED_GRAPH = false;// 无向图标志  
    
    private static final boolean DIRECTED_GRAPH = true;// 有向图标志  
    
    private int capacity;
    
    private boolean graphType;
    
    /** 实际向量大小 */
    private int vertexSize;
    
    // 存储所有顶点信息的一维数组  
    private Object[] vertexesArray;
    
    // 存储图中顶点之间关联关系的二维数组,及边的关系  
    private boolean[][] edgesMatrix;
    
    // 记录第i个节点是否被访问过  
    private boolean[] visited;
    
    /**
     * @param graphType 图的类型：有向图/无向图 
     * @param size 图的 最大容量值 
     */
    private ArrayGraph(boolean graphType, int capacity)
    {
        this.graphType = graphType;
        this.capacity = capacity;
        
        // 原始数据
        this.vertexSize = 0;
        this.vertexesArray = new Object[capacity];
        this.edgesMatrix = new boolean[capacity][capacity];
        
        // 临时数据
        this.visited = new boolean[capacity];
    }
    
    /**
     * .获取指定点的值
     * @param index 位置
     * @return 值
     */
    public Object getValue(int index)
    {
        checkValid(index);
        visited[index] = true;
        return vertexesArray[index];
    }
    
    /**
     * .获取指定点的所有下一个值
     * @param index 当前位置
     * @return 所有下一个位置
     */
    public int[] getNextArray(int index)
    {
        checkValid(index);
        
        int[] nextArray = new int[capacity];
        int length = 0;
        for (int i = 0; i < edgesMatrix.length; i++)
        {
            if (edgesMatrix[index][i])
            {
                nextArray[length] = i;
                length++;
            }
        }
        
        return Arrays.copyOf(nextArray, length);
    }
    
    public void resetState()
    {
        Arrays.fill(visited, false);
    }
    
    public void setVisitedEnable(int index)
    {
        checkValid(index);
        visited[index] = true;
    }
    
    public boolean isVisited(int index)
    {
        checkValid(index);
        return visited[index];
    }
    
    public int getSize()
    {
        return vertexSize;
    }
    
    /**
     * .添加点
     * @param val 点内容
     * @return
     */
    private void addVertex(Object val)
    {
        assert (null != val); // 如果为空,则终止程序运行
        
        vertexesArray[vertexSize] = val;
        vertexSize++;
    }
    
    /**
     * .添加边[方向][第一个位置 指向 第二个位置，有则返回true]
     * @param vnum1 第一个点位置
     * @param vnum2 第二个点位置
     */
    private void addEdge(int vnum1, int vnum2)
    {
        assert (vnum1 >= 0 && vnum1 < capacity);
        assert (vnum2 >= 0 && vnum2 < capacity);
        assert (vnum1 != vnum2);
        
        if (graphType) // 有向图
        {
            edgesMatrix[vnum1][vnum2] = true;
        }
        else
        {
            edgesMatrix[vnum1][vnum2] = true;
            edgesMatrix[vnum2][vnum1] = true;
        }
    }
    
    private void checkValid(int index)
    {
        if (index < 0 || index >= capacity)
        {
            throw new IllegalArgumentException("index is error");
        }
    }
}
