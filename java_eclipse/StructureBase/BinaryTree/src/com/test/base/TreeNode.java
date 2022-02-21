package com.test.base;

public class TreeNode<T>
{
    private T data;
    
    private TreeNode<T> leftNode;
    
    private TreeNode<T> rightNode;
    
    public TreeNode(T data)
    {
        super();
        this.data = data;
    }
    
    public TreeNode(T data, TreeNode<T> leftNode, TreeNode<T> rightNode)
    {
        super();
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    
    public T getData()
    {
        return data;
    }
    
    public void setData(T data)
    {
        this.data = data;
    }
    
    public TreeNode<T> getLeftNode()
    {
        return leftNode;
    }
    
    public void setLeftNode(TreeNode<T> leftNode)
    {
        this.leftNode = leftNode;
    }
    
    public TreeNode<T> getRightNode()
    {
        return rightNode;
    }
    
    public void setRightNode(TreeNode<T> rightNode)
    {
        this.rightNode = rightNode;
    }
}
