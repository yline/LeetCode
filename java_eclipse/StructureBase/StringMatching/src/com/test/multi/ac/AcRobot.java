package com.test.multi.ac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Ac自动机
 * 
 * @author YLine
 *
 * 2019年4月8日 下午6:24:55
 */
public class AcRobot
{
    private AcNode root = new AcNode('/', 0); // 无效的，头字符
    
    /**
     * 更新Trie树
     * @param str 新增加的模式串
     */
    public void insert(String str)
    {
        // 构建树
        AcNode temp = root;
        for (int i = 0; i < str.length(); i++)
        {
            temp = temp.insert(str.charAt(i), i + 1);
        }
        temp.setFlag(true);
    }
    
    /**
     * 插入或删除Trie树后，需要整体遍历一次，以重新构建failed指针
     * 操作，是层遍历做的
     */
    public void buildFailurePointer()
    {
        // 第一层
        Queue<AcNode> queue = new LinkedList<>();
        queue.add(root);
        
        // 开始逐个遍历
        while (!queue.isEmpty())
        {
            // 当前抛出的节点
            AcNode popNode = queue.remove();
            
            // 遍历抛出节点的子节点
            for (AcNode childNode : popNode.next.values())
            {
                // 当前父节点为根节点时
                if (popNode == root)
                {
                    childNode.failed = root;
                }
                else
                {
                    // 上一个节点的坏指针
                    AcNode topFailedNode = popNode.failed;
                    while (null != topFailedNode)
                    {
                        AcNode topFailedNextNode = topFailedNode.next.get(childNode.value);
                        if (null != topFailedNextNode)
                        {
                            childNode.failed = topFailedNextNode;
                            break;
                        }
                        else
                        {
                            topFailedNode = topFailedNode.failed;
                        }
                    }
                    
                    // 没有遍历到相应的内容[或者失败指针，指向root]
                    if (null == topFailedNode)
                    {
                        childNode.failed = root;
                    }
                }
                
                // 添加子节点
                queue.add(childNode);
            }
        }
    }
    
    public void logAcNode()
    {
        logAcNodeDfs(root, 1);
    }
    
    /**
     * 遍历所有的内容，打印出来；方便查看错误
     * @param root
     */
    private void logAcNodeDfs(AcNode root, int deep)
    {
        for (AcNode childNode : root.next.values())
        {
            System.out.println(childNode.toString());
            logAcNodeDfs(childNode, deep + 1);
        }
    }
    
    /**
     * 在主串中，找到所有的模式串的，位置以及对应的模式串(不管嵌套，即：一旦满足，则直接下一个开始查询)
     * @param str 主串
     * @return 所有匹配的模式串的位置 以及 对应的模式串
     */
    public List<AcResult> find(String str)
    {
        List<AcResult> resultList = new ArrayList<>();
        
        AcNode temp = root;
        for (int i = 0; i < str.length(); i++)
        {
            AcNode childNode = temp.find(str.charAt(i));
            
            // 不是从root出发，并且下一个为空，直接指向失败指针
            while (root != temp && null == childNode)
            {
                temp = temp.failed;
                childNode = temp.find(str.charAt(i));
            }
            
            // 首个就未找到内容，直接下一个
            if (null == childNode)
            {
                temp = root;
                continue;
            }
            else
            {
                if (childNode.isEnd)
                {
                    resultList.add(new AcResult(str, i, childNode.length));
                    temp = root;
                }
                else
                {
                    temp = childNode;
                }
            }
        }
        
        return resultList;
    }
    
    public static class AcResult
    {
        // 主串中开始的位置
        private int startIndex;
        
        // 对应的模式串的内容
        private String patternStr;
        
        public AcResult(String mainStr, int end, int length)
        {
            startIndex = end - length + 1;
            patternStr = mainStr.substring(startIndex, end + 1);
        }

        @Override
        public String toString()
        {
            return "start = " + startIndex + ", pattern = " + patternStr;
        }
        
        public int getStartIndex()
        {
            return startIndex;
        }
        
        public void setStartIndex(int startIndex)
        {
            this.startIndex = startIndex;
        }
        
        public String getPatternStr()
        {
            return patternStr;
        }
        
        public void setPatternStr(String patternStr)
        {
            this.patternStr = patternStr;
        }
    }
}
