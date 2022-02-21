package com.test.linklist;

import com.test.base.LinkGraph;

public class SolutionLinkDFS implements LinkSolution
{
    
    @Override
    public Object[] traverse(LinkGraph graph)
    {
        int size = graph.getSize();
        Object[] objArray = new Object[size];
        
        dfs(graph, objArray, new boolean[size], 0, 0);
        
        return objArray;
    }
    
    private void dfs(LinkGraph graph, Object[] objArray, boolean[] visited, int index, int deep)
    {
        if (visited[index])
        {
            return;
        }
        
        visited[index] = true;
        LinkGraph.Node node = graph.getValue(index);
        
        objArray[deep] = node.getValue();
        deep++;
        
        for (LinkGraph.Node temp : node.getDataList())
        {
            dfs(graph, objArray, visited, temp.getPosition(), deep);
        }
    }
}
