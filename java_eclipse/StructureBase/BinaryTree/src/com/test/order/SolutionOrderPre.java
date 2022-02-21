package com.test.order;

import java.util.Stack;

import com.test.base.TreeNode;

/**
 * .先序遍历
 * @author YLine
 *
 * 2019年2月22日 下午5:28:32
 */
public class SolutionOrderPre
{
    private StringBuilder stringBuilder;
    
    public String preOrder(TreeNode<String> node)
    {
        stringBuilder = new StringBuilder();
        preOrderInner(node);
        return stringBuilder.toString();
    }
    
    /**
     * .先序遍历;递归
     * @param node
     */
    private void preOrderInner(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        stringBuilder.append(node.getData());
        preOrderInner(node.getLeftNode());
        preOrderInner(node.getRightNode());
    }
    
    public String preOrderNonRecursive(TreeNode<String> node)
    {
        stringBuilder = new StringBuilder();
        preOrderNonRecursiveInner(node);
        return stringBuilder.toString();
    }
    
    /**
     * .先序遍历，非递归
     * .栈 ==> 先进后出
     * @param node
     */
    private void preOrderNonRecursiveInner(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        Stack<TreeNode<String>> stack = new Stack<>();
        stack.push(node);
        
        while (!stack.isEmpty())
        {
            TreeNode<String> temp = stack.pop();
            
            stringBuilder.append(temp.getData());
            
            if (null != temp.getRightNode())
            {
                stack.push(temp.getRightNode());
            }
            
            if (null != temp.getLeftNode())
            {
                stack.push(temp.getLeftNode());
            }
        }
    }
    
    public String preOrderNonRecursive2(TreeNode<String> node)
    {
        stringBuilder = new StringBuilder();
        preOrderNonRecursive2Inner(node);
        return stringBuilder.toString();
    }
    
    /**
     * .先序遍历，非递归
     * .栈 ==> 先进后出
     * @param node
     */
    private void preOrderNonRecursive2Inner(TreeNode<String> node)
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
                stringBuilder.append(root.getData());
                stack.push(root); // 先访问再入栈
                
                root = root.getLeftNode();
            }
            
            root = stack.pop();
            root = root.getRightNode();
        }
    }
}
