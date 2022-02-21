package com.test.topology;

import java.util.LinkedList;

/**
 * Kahn 算法 实现 拓扑排序
 * 
 * 
 * @author YLine
 *
 * 2019年4月28日 上午10:38:53
 */
public class Kahn
{
    public static void sortByKahn(TopoGraph graph)
    {
        int size = graph.getSize();
        int[] inDegree = new int[size]; // 统计每个顶点的入度
        for (int i = 0; i < size; i++)
        {
            // 如果该节点的子类，则将子类入度加1
            TopoGraph.Node node = graph.getVertex(i);
            for (TopoGraph.Node child : node.getChildList())
            {
                int index = graph.getIndexByNode(child);
                if (index != -1)
                {
                    inDegree[index]++;
                }
            }
        }
        
        // 入度统计完成，依据入度依次进行处理
        LinkedList<TopoGraph.Node> queue = new LinkedList<>();
        for (int i = 0; i < size; i++)
        {
            if (inDegree[i] == 0)
            {
                queue.add(graph.getVertex(i));
            }
        }
        
        StringBuilder sBuilder = new StringBuilder();
        // 遍历处理
        while (!queue.isEmpty())
        {
            TopoGraph.Node node = queue.remove();
            sBuilder.append(node.getValue());
            sBuilder.append(" -> ");
            
            // 某个节点出度后，该节点的子节点，入度全部 减一
            for (TopoGraph.Node child : node.getChildList())
            {
                int index = graph.getIndexByNode(child);
                if (index != -1)
                {
                    inDegree[index]--;
                    if (inDegree[index] == 0)
                    {
                        queue.add(child);
                    }
                }
            }
        }
        
        System.out.println(sBuilder.toString());
    }
}
