package com.test.shortest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 路径图
 * @author YLine
 *
 * 2019年4月28日 下午5:23:07
 */
public class PathGraph
{
    private List<Vertex> vertextList;
    
    public PathGraph()
    {
        this.vertextList = new ArrayList<>();
    }
    
    public void addVertex(int id)
    {
        vertextList.add(new Vertex(id));
    }
    
    public void addEdge(int startIndex, int endIndex, int weight)
    {
        checkValid(startIndex);
        checkValid(endIndex);
        
        Vertex start = vertextList.get(startIndex);
        Vertex end = vertextList.get(endIndex);
        start.addEdge(new Edge(start, end, weight));
    }
    
    private void checkValid(int index)
    {
        if (index < 0 || index >= vertextList.size())
        {
            throw new IllegalAccessError("index outOfBoundException, index = " + index);
        }
    }
    
    public int getVertexSize()
    {
        return vertextList.size();
    }
    
    public Vertex getVertex(int index)
    {
        checkValid(index);
        
        return vertextList.get(index);
    }
    
    public int indexOf(Vertex vertex)
    {
        if (null == vertex)
        {
            return -1;
        }
        return vertextList.indexOf(vertex);
    }
    
    /**
     * 边
     */
    public static class Edge
    {
        private Vertex start; // 边起始顶点，编号
        
        private Vertex end; // 边终止顶点，编号
        
        private int weight; // 权重
        
        public Edge(Vertex start, Vertex end, int weight)
        {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        
        public int getWeight()
        {
            return weight;
        }
        
        public Vertex getEndVertex()
        {
            return end;
        }
    }
    
    /**
     * 顶点
     */
    public static class Vertex
    {
        private int id; // 顶点编号
        
        private List<Edge> edgeArray;
        
        public Vertex(int id)
        {
            this.id = id;
            this.edgeArray = new ArrayList<>();
        }
        
        public void addEdge(Edge edge)
        {
            // 去重校验
            for (Edge oldEdge : edgeArray)
            {
                if (oldEdge.end.id == edge.end.id)
                {
                    throw new IllegalAccessError("edge double, end id = " + edge.end.id);
                }
            }
            
            // 添加内容
            edgeArray.add(edge);
        }
        
        public int getEdgeSize()
        {
            return edgeArray.size();
        }
        
        public Edge getEdge(int index)
        {
            return edgeArray.get(index);
        }
        
        public Iterator<Edge> iterator()
        {
            return edgeArray.iterator();
        }
        
        public int getId()
        {
            return id;
        }
    }
}
