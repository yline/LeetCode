package com.test.order;

import java.util.Stack;

import com.test.base.TreeNode;

/**
 * .中序遍历
 * @author YLine
 *
 * 2019年2月22日 下午5:29:35
 */
public class SolutionOrderMiddle
{
    private StringBuilder stringBuilder;
    
    public String middleOrder(TreeNode<String> node)
    {
        stringBuilder = new StringBuilder();
        middleOrderInner(node);
        return stringBuilder.toString();
    }
    
    /**
     * .中序遍历;递归
     * @param node
     */
    private void middleOrderInner(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        middleOrderInner(node.getLeftNode());
        stringBuilder.append(node.getData());
        middleOrderInner(node.getRightNode());
    }
    
    public String middleOrderNonRecursive(TreeNode<String> node)
    {
        stringBuilder = new StringBuilder();
        middleOrderNonRecursiveInner(node);
        return stringBuilder.toString();
    }
    
    /**
     * .中序遍历，非递归
     * .栈 ==> 先进后出
     * @param node
     */
    private void middleOrderNonRecursiveInner(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        Stack<TreeNode<String>> stack = new Stack<>();
        TreeNode<String> root = new TreeNode<String>(node.getData());
        root = node; // 赋值
        
        while (null != root || !stack.isEmpty())
        {
            while (null != root)
            {
                stack.push(root); // 先访问再入栈
                
                root = root.getLeftNode();
            }
            
            root = stack.pop();
            stringBuilder.append(root.getData());
            
            root = root.getRightNode();
        }
    }
}
