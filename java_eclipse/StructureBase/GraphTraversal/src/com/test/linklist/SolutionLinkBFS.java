package com.test.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.LinkGraph;

public class SolutionLinkBFS implements LinkSolution
{
    
    @Override
    public Object[] traverse(LinkGraph graph)
    {
        Object[] objArray = new Object[graph.getSize()];
        
        objArray[0] = graph.getValue(0).getValue();
        boolean[] visited = new boolean[graph.getSize()];
        visited[0] = true;
        
        recurse(objArray, visited, 1, Arrays.asList(graph.getValue(0)));
        return objArray;
    }
    
    private void recurse(Object[] objArray, boolean[] visited, int deep, List<LinkGraph.Node> nodeList)
    {
        if (nodeList.isEmpty())
        {
            return;
        }
        
        List<LinkGraph.Node> newList = new ArrayList<>();
        for (LinkGraph.Node node : nodeList) // 上一次，加入的Node
        {
            for (LinkGraph.Node temp : node.getDataList())
            {
                if (!visited[temp.getPosition()])
                {
                    newList.add(temp);
                    
                    visited[temp.getPosition()] = true;
                    objArray[deep] = temp.getValue();
                    deep++;
                }
            }
        }
        
        recurse(objArray, visited, deep, newList);
    }
}
