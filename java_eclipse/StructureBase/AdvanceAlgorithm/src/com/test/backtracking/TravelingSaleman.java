package com.test.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 旅行商问题
 * 
 * 一个售货员必须访问n个城市，这n个城市是一个完全图，售货员需要恰好访问所有城市的一次，并且回到最终的城市。
 * 城市于城市之间有一个旅行费用，售货员希望旅行费用之和最少。
 * 
 * 参考：https://www.cnblogs.com/dddyyy/p/10084673.html
 * 
 * @author YLine
 *
 * 2019年4月15日 下午2:15:04
 */
public class TravelingSaleman
{
    
    /**
     * 全排列方式，获取旅行商最小值【时间复杂度挺高的】
     * @param graph 有向图
     * @return 最小值
     */
    public int travelMin(Graph graph)
    {
        mMinValue = Integer.MAX_VALUE;
        mNodeList = null;
        
        // 第一层
        List<Node> dataList = new ArrayList<>();
        for (int i = 0; i < graph.getSize(); i++)
        {
            dataList.add(graph.getVertex(i));
            travelInner(graph, dataList, 0);
            dataList.remove(graph.getVertex(i));
        }
        
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < mNodeList.size(); i++)
        {
            Node node = mNodeList.get(i);
            int cost;
            if (i == mNodeList.size() - 1)
            {
                cost = mNodeList.get(i).getNeighborCost(mNodeList.get(0));
            }
            else
            {
                cost = mNodeList.get(i).getNeighborCost(mNodeList.get(i + 1));
            }
            sBuilder.append(String.format("%s -%d- ", node.value, cost));
        }
        
        if (mNodeList.size() > 0)
        {
            sBuilder.append(mNodeList.get(0).value);
        }
        sBuilder.append(String.format("; min = " + mMinValue));
        System.out.println(sBuilder.toString());
        return mMinValue;
    }
    
    private int mMinValue = Integer.MAX_VALUE;
    
    private List<Node> mNodeList;
    
    /**
     * 全排列
     * @param graph
     * @param dataList
     * @param currentCost
     */
    private void travelInner(Graph graph, List<Node> dataList, int currentCost)
    {
        // 当已经到结束节点，或者，已经超过最小值的时候；直接结束
        if (graph.getSize() == dataList.size() || currentCost >= mMinValue)
        {
            // 还得加上结束节点到出发节点的值
            int allCost = currentCost + dataList.get(dataList.size() - 1).getNeighborCost(dataList.get(0));
            if (mMinValue > allCost)
            {
                mMinValue = allCost;
                mNodeList = new ArrayList<>(dataList);
            }
            return;
        }
        
        for (int i = 0; i < graph.getSize(); i++)
        {
            Node vertex = graph.getVertex(i);
            if (!dataList.contains(vertex))
            {
                int cost = dataList.get(dataList.size() - 1).getNeighborCost(vertex); // 从上个城市到下个城市的花费
                dataList.add(vertex);
                travelInner(graph, dataList, currentCost + cost);
                dataList.remove(vertex);
            }
        }
    }
    
    /**
     * 单向图
     */
    public static class Graph
    {
        private List<Node> dataList;
        
        public Graph()
        {
            dataList = new ArrayList<>();
        }
        
        /**
         * 添加节点
         * @param val 节点内容
         */
        public void addVertex(String val)
        {
            dataList.add(new Node(val));
        }
        
        /**
         * 添加边
         * @param start 开始节点
         * @param end 结束节点
         * @param cost 边的值
         */
        public void addEdge(int start, int end, int cost)
        {
            checkValid(start);
            checkValid(end);
            
            dataList.get(start).addNeighbor(dataList.get(end), cost);
        }
        
        /**
         * 获取某个节点的内容
         * @param index 位置 
         * @return 节点
         */
        public Node getVertex(int index)
        {
            checkValid(index);
            return dataList.get(index);
        }
        
        public int getSize()
        {
            return dataList.size();
        }
        
        private void checkValid(int index)
        {
            if (index < 0 || index >= dataList.size())
            {
                throw new IllegalArgumentException("index is error");
            }
        }
    }
    
    /**
     * 节点对象
     */
    public static class Node
    {
        // 节点内容
        private String value;
        
        // 边内容
        private HashMap<Node, Integer> hashMap;
        
        public Node(String value)
        {
            this.value = value;
            this.hashMap = new HashMap<>();
        }
        
        public String getValue()
        {
            return value;
        }
        
        /**
         * @param node 目标节点
         * @param cost 达到目标节点，所，花费的金额
         */
        public void addNeighbor(Node node, int cost)
        {
            if (!hashMap.containsKey(node))
            {
                hashMap.put(node, cost);
            }
        }
        
        /**
         * @param node 目标节点
         * @return 返回
         */
        public int getNeighborCost(Node node)
        {
            Integer cost = hashMap.get(node);
            return (null == cost ? -1 : cost);
        }
    }
}
