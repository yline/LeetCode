package com.yline.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 图的数据结构
 * @author YLine
 *
 * 2019年4月29日 上午9:15:14
 */
public class Graph
{
    private List<Vertex> mVertexList;
    
    public Graph()
    {
        mVertexList = new ArrayList<>();
    }
    
    public void addVertex(int id)
    {
        mVertexList.add(new Vertex(id));
    }
    
    public void addVertex(int id, String name)
    {
        mVertexList.add(new Vertex(id, name));
    }
    
    public void addEdge(int startIndex, int endIndex)
    {
        checkValid(startIndex);
        checkValid(endIndex);
        
        Vertex start = mVertexList.get(startIndex);
        Vertex end = mVertexList.get(endIndex);
        start.addEdge(end);
    }
    
    public void addEdge(int startIndex, int endIndex, int weight)
    {
        checkValid(startIndex);
        checkValid(endIndex);
        
        Vertex start = mVertexList.get(startIndex);
        Vertex end = mVertexList.get(endIndex);
        start.addEdge(end, weight);
    }
    
    public int getVertexSize()
    {
        return mVertexList.size();
    }
    
    public Vertex getVertex(int index)
    {
        checkValid(index);
        
        return mVertexList.get(index);
    }
    
    public int indexOf(Vertex vertex)
    {
        if (null == vertex)
        {
            return -1;
        }
        return mVertexList.indexOf(vertex);
    }
    
    private void checkValid(int index)
    {
        if (index < 0 || index >= mVertexList.size())
        {
            throw new IllegalAccessError("index outOfBoundException, index = " + index);
        }
    }
    
    /**
     * 顶点
     */
    public static class Vertex
    {
        private int mId; // 顶点编号
        
        private String mName; // 顶点名称
        
        private HashSet<Edge> mEdgeSet; // 顶点对应，所有的边【这样，就可以防止重复的边的存在了】
        
        public Vertex(int id)
        {
            this(id, String.valueOf(id));
        }
        
        public Vertex(int id, String name)
        {
            this.mId = id;
            this.mName = name;
        }
        
        public int getId()
        {
            return mId;
        }
        
        public String getName()
        {
            return mName;
        }
        
        public void addEdge(Vertex end)
        {
            mEdgeSet.add(new Edge(this, end));
        }
        
        public void addEdge(Vertex end, int weight)
        {
            mEdgeSet.add(new Edge(this, end, weight));
        }
        
        public int getEdgeSize()
        {
            return mEdgeSet.size();
        }
        
        public Iterator<Edge> iterator()
        {
            return mEdgeSet.iterator();
        }
        
        @Override
        public boolean equals(Object obj)
        {
            if (obj instanceof Vertex)
            {
                return (mId == ((Vertex)obj).getId());
            }
            return super.equals(obj);
        }
    }
    
    /**
     * 边
     */
    public static class Edge
    {
        private Vertex mStart; // 起始顶点
        
        private Vertex mEnd; // 终止顶点
        
        private int mWeight; // 权重
        
        public Edge(Vertex start, Vertex end)
        {
            this(start, end, 1);
        }
        
        public Edge(Vertex start, Vertex end, int weight)
        {
            this.mStart = start;
            this.mEnd = end;
            this.mWeight = weight;
        }
        
        public Vertex getStart()
        {
            return mStart;
        }
        
        public Vertex getEnd()
        {
            return mEnd;
        }
        
        public int getWeight()
        {
            return mWeight;
        }
        
        @Override
        public boolean equals(Object obj)
        {
            if (obj instanceof Edge)
            {
                Edge edge = (Edge)obj;
                return (edge.getStart().equals(mStart) && edge.getEnd().equals(mEnd));
            }
            return super.equals(obj);
        }
    }
}
