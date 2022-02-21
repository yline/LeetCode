package com.test;

import com.test.shortest.Dijkstra;
import com.test.shortest.PathGraph;

import junit.framework.TestCase;

public class ShortestSample extends TestCase
{
    public void testShortest()
    {
        PathGraph graph = Dijkstra.createGraph();
        Dijkstra.shortest(graph, 0, 5);
    }
}
