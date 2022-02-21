package com.test;

import java.util.HashMap;
import java.util.Map;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * A linked list is given such that
 * each node contains an additional random pointer
 * which could point to any node in the list or null.
 * 
 * Return a "deep copy" of the list.
 * 
 * Note:
 * You must return the copy of the given head as a reference to the cloned list.
 * 
 * 结果是一样的，只是测试代码有问题而已
 * 
 * @author YLine
 *
 * 2019年12月12日 下午4:07:00
 */
public class SolutionA implements Solution
{
    @Override
    public Node copyRandomList(Node head)
    {
        if (null == head)
        {
            return null;
        }
        
        HashMap<Node, Node> cacheMap = new HashMap<>();
        dfsCopyNode(cacheMap, head);
        Node result = cacheMap.get(head);
        return result;
    }
    
    private void dfsCopyNode(Map<Node, Node> cacheMap, Node oldNode)
    {
        Node newNode = cacheMap.get(oldNode); // 获取新的内容
        
        // 如果不为空，说明没必要了
        if (null == newNode)
        {
            newNode = new Node();
            newNode.val = oldNode.val; // 赋值
            
            // 赋值下一个
            if (null != oldNode.next)
            {
                dfsCopyNode(cacheMap, oldNode.next);
                newNode.next = cacheMap.get(oldNode.next);
            }
            
            // 必须放在前面，避免相互指向，导致死锁
            cacheMap.put(oldNode, newNode);
            
            // 赋值随机内容
            if (null != oldNode.random)
            {
                // 避免是自身，从而导致死锁
                if (oldNode != oldNode.random)
                {
                    dfsCopyNode(cacheMap, oldNode.random);
                    newNode.random = cacheMap.get(oldNode.random);
                }
                else
                {
                    newNode.random = newNode;
                }
            }
        }
    }
}
