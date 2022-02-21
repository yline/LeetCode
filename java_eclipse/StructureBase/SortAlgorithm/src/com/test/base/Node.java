package com.test.base;

public class Node
{
    private static final int[] ARRAY = {5, 8, 4, 12, 32, -12, -43, 0, 9, 43, -23, 8, -4, 43, 5};
    
    public static Node[] createNodeArray()
    {
        Node[] nodeArray = new Node[ARRAY.length];
        for (int i = 0; i < nodeArray.length; i++)
        {
            nodeArray[i] = new Node(ARRAY[i], i);
        }
        return nodeArray;
    }
    
    public int value;
    
    public int index;
    
    public Node(int value, int index)
    {
        super();
        this.value = value;
        this.index = index;
    }
    
    @Override
    public String toString()
    {
        return value + "(" + index + ")";
    }
}
