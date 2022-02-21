package com.test;

import java.util.LinkedList;
import java.util.Queue;

import com.test.base.TreeNode;

/**
 * .计算节点总数
 * @author YLine
 *
 * 2019年2月22日 下午5:06:37
 */
public class SolutionCount
{
    public int getNodeNumber(TreeNode<String> node)
    {
        if (null == node)
        {
            return 0;
        }
        
        return getNodeNumber(node.getLeftNode()) + getNodeNumber(node.getRightNode()) + 1;
    }
    
    public int getNodeNumberNonRecursive(TreeNode<String> node)
    {
        int i = 0;
        
        Queue<TreeNode<String>> queue = new LinkedList<>();
        TreeNode<String> root = node;
        
        queue.add(root);
        
        while (!queue.isEmpty())
        {
            TreeNode<String> temp = queue.poll();
            i++;
            
            if (null != temp.getLeftNode())
            {
                queue.add(temp.getLeftNode());
            }
            
            if (null != temp.getRightNode())
            {
                queue.add(temp.getRightNode());
            }
        }
        
        return i;
    }
}
