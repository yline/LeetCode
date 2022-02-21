package com.test.topology;

import java.util.Arrays;

/**
 * DFS(Deep first search)实现 拓扑排序
 * 
 * 如果出现环，则会出现输出顶点，少于实际顶点
 * 
 * @author YLine
 *
 * 2019年4月28日 上午10:39:12
 */
public class DFS
{
    /**
     * 原本  A --> B
     * A是父类，B是子类；
     * 
     * 而DFS要求，先反过来，删除；即：建立一个图，B --> A
     * 
     * @param graph
     */
    public static void sortByDFS(TopoGraph graph)
    {
        // 首先构建反数据，这里省略了，因此需要反过来看输出日志
        
        DFS dfs = new DFS();
        dfs.sortByDFSInner(graph);
    }
    
    private StringBuilder sBuilder;
    
    private void sortByDFSInner(TopoGraph graph)
    {
        sBuilder = new StringBuilder();
        
        int size = graph.getSize();
        
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);
        
        for (int i = 0; i < size; i++)
        {
            dfs(graph, i, visited);
        }
        
        System.out.println(sBuilder.toString());
    }
    
    private void dfs(TopoGraph graph, int index, boolean[] visited)
    {
        if (visited[index])
        {
            return;
        }
        
        TopoGraph.Node node = graph.getVertex(index);
        visited[index] = true;
        
        for (TopoGraph.Node child : node.getChildList())
        {
            int newIndex = graph.getIndexByNode(child);
            if (newIndex != -1)
            {
                dfs(graph, newIndex, visited);
            }
        }
        
        // 这里要放在最后
        sBuilder.append(node.getValue());
        sBuilder.append(" -> ");
    }
}
