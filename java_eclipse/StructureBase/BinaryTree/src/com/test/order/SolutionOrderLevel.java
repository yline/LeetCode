package com.test.order;

import java.util.LinkedList;
import java.util.Queue;

import com.test.base.TreeNode;

/**
 * .层序遍历
 * @author YLine
 *
 * 2019年2月22日 下午5:37:25
 */
public class SolutionOrderLevel
{
    
    private StringBuilder stringBuilder;
    
    public String levelOrder(TreeNode<String> node)
    {
        stringBuilder = new StringBuilder();
        levelOrderInner(node);
        return stringBuilder.toString();
    }
    
    /**
     * .层序遍历;非递归
     * .队列 ==> 先进先出 规则
     * @param node
     */
    private void levelOrderInner(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        Queue<TreeNode<String>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty())
        {
            TreeNode<String> temp = queue.poll();
            stringBuilder.append(temp.getData());
            
            if (null != temp.getLeftNode())
            {
                queue.add(temp.getLeftNode());
            }
            
            if (null != temp.getRightNode())
            {
                queue.add(temp.getRightNode());
            }
        }
    }
}
