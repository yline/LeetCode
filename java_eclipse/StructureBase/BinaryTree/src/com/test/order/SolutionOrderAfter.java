package com.test.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.test.base.TreeNode;

/**
 * .后序遍历
 * @author YLine
 *
 * 2019年2月22日 下午5:33:21
 */
public class SolutionOrderAfter
{
    private StringBuilder stringBuilder;
    
    public String afterOrder(TreeNode<String> node)
    {
        stringBuilder = new StringBuilder();
        afterOrderInner(node);
        return stringBuilder.toString();
    }
    
    /**
     * .后序遍历;递归
     * @param node
     */
    private void afterOrderInner(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        afterOrderInner(node.getLeftNode());
        afterOrderInner(node.getRightNode());
        stringBuilder.append(node.getData());
    }
    
    public String afterOrderNonRecursive(TreeNode<String> node)
    {
        stringBuilder = new StringBuilder();
        afterOrderNonRecursiveInner(node);
        return stringBuilder.toString();
    }
    
    private void afterOrderNonRecursiveInner(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        Stack<TreeNode<String>> stack = new Stack<>();
        Map<TreeNode<String>, Boolean> map = new HashMap<>();
        TreeNode<String> root = node;
        
        stack.push(root);
        
        while (!stack.isEmpty())
        {
            TreeNode<String> temp = stack.peek(); // 寻找,但不移除
            
            if (null != temp.getLeftNode() && !map.containsKey(temp.getLeftNode()))
            {
                temp = temp.getLeftNode();
                while (null != temp)
                {
                    if (map.containsKey(temp))
                    {
                        break;
                    }
                    else
                    {
                        stack.push(temp);
                    }
                    temp = temp.getLeftNode();
                }
                continue;
            }
            
            if (null != temp.getRightNode() && !map.containsKey(temp.getRightNode()))
            {
                stack.push(temp.getRightNode());
                continue;
            }
            
            // 最后统一,遍历
            TreeNode<String> tempNode = stack.pop();
            map.put(tempNode, true);
            stringBuilder.append(tempNode.getData());
        }
    }
}
