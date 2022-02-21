package com.test;

import com.test.topology.DFS;
import com.test.topology.Kahn;
import com.test.topology.TopoGraph;

import junit.framework.TestCase;

public class TopologySample extends TestCase
{
    public void testKahn()
    {
        System.out.println("----------------- Kahn --------------");
        TopoGraph graph = TopoGraph.createGraph();
        Kahn.sortByKahn(graph);
    }
    
    public void testDFS()
    {
        System.out.println("----------------- DFS --------------");
        TopoGraph graph = TopoGraph.createGraph();
        DFS.sortByDFS(graph);
    }
}
