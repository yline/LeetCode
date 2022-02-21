package com.test.base;

import java.util.List;

public class Node
{
    public int val;
    
    public List<Node> neighbors;
    
    public Node(int x, List<Node> neigh)
    {
        val = x;
        neighbors = neigh;
    }
}
