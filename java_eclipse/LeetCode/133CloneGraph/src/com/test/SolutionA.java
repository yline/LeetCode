package com.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

import com.test.base.Node;

/**
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * 
 * note:
 * 1, The number of nodes will be between 1 and 100.
 * 2, The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * 3, Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * 4, You must return the copy of the given node as a reference to the cloned graph.
 * 
 * PS：应该不用考虑，没有连接的图的点；因为，原始的都遍历不到
 * 
 * @author YLine
 *
 * 2019年12月6日 上午10:08:28
 */
public class SolutionA
{
    public Node cloneGraph(Node node)
    {
        if (null == node)
        {
            return null;
        }
        
        Node newNode = new Node(node.val, new ArrayList<Node>());
        
        // 旧和新的一一对应关系，保证不会因为node.x相等，而导致弄混
        HashMap<Node, Node> cacheMap = new HashMap<>(); // 保存添加过的老node
        cacheMap.put(node, newNode);

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty())
        {
            Node tempNode = queue.pollFirst();
            
            Node newTempNode = cacheMap.get(tempNode); // 已经肯定添加过了
            for (Node neighborNode : tempNode.neighbors)
            {
                Node newNeighborNode = cacheMap.get(neighborNode);
                
                // 从来没有添加过
                if (null == newNeighborNode)
                {
                    newNeighborNode = new Node(neighborNode.val, new ArrayList<Node>());
                    cacheMap.put(neighborNode, newNeighborNode);
                    queue.add(neighborNode);
                }
                
                // 不管有没有添加过，最终都要加到相邻上
                newTempNode.neighbors.add(newNeighborNode);
            }
        }
        
        return newNode;
    }
}
