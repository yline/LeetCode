package com.test.base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * 测试，打印图出来
 * @author YLine
 *
 * 2019年12月6日 上午10:37:22
 */
public class NodeUtil
{
    public static void print(Node node)
    {
        if (null == node)
        {
            System.out.println("node = null");
            return;
        }
        
        StringBuilder sBuilder = new StringBuilder();
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        
        HashSet<Node> cacheSet = new HashSet<>();
        cacheSet.add(node);
        
        while (!queue.isEmpty())
        {
            Node tempNode = queue.pollFirst();
            sBuilder.append(tempNode.val);
            sBuilder.append(" -> [");
            
            for (Node neighborNode : tempNode.neighbors)
            {
                sBuilder.append(neighborNode.val);
                sBuilder.append(',');
                
                if (!cacheSet.contains(neighborNode))
                {
                    cacheSet.add(neighborNode);
                    queue.add(neighborNode);
                }
            }
            
            sBuilder.append(']');
            sBuilder.append('\n');
        }
        
        System.out.println(sBuilder.toString());
    }
}
