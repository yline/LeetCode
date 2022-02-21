package com.test.base;

import java.util.LinkedList;

public class TreeNodeUtils
{
    /**
     * .判断两个结构是否相等
     */
    public static boolean isEqual(TreeNode a, TreeNode b)
    {
        if (null == a && null == b)
        {
            return true;
        }
        
        if (null == a || null == b)
        {
            return false;
        }
        
        return a.val == b.val && isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }
    
    /**
     * .建立一个二叉树，层级遍历【满的遍历】
     * .得到的是一个满二叉树,要求输入的也是满二叉树
     */
    public static TreeNode build(Integer... arrays)
    {
        if (null == arrays || arrays.length == 0)
        {
            return null;
        }

        // 计算层级数
        int levelTotal = 0, length = arrays.length;
        while (length != 0)
        {
            length >>= 1;
            levelTotal++;
        }
        final int total = 1 << levelTotal; // 总个数
        System.out.println("build level = " + levelTotal + ", total = " + total);
        
        TreeNode root = new TreeNode(arrays[0]);
        LinkedList<TreeNode> cacheList = new LinkedList<>();
        cacheList.addLast(root);
        
        int index = 1;
        while (index < total)
        {
            TreeNode temp = cacheList.poll();
            
            if (null == temp)
            {
                // 空后面是两个空
                cacheList.add(null);
                cacheList.add(null);
            }
            else
            {
                temp.left = getTreeNode(arrays, index);
                temp.right = getTreeNode(arrays, index + 1);
                
                cacheList.add(temp.left);
                cacheList.add(temp.right);
            }
            
            index += 2;
        }
        
        return root;
    }
    
    private static TreeNode getTreeNode(Integer[] array, int index)
    {
        if (index < array.length && null != array[index])
        {
            return new TreeNode(array[index]);
        }
        return null;
    }
    
    /**
     * .打印一个二叉树，层级遍历；采用的规则是，数值后面，的null也输出。更多的就不输出了
     */
    public static void print(TreeNode root)
    {
        if (null == root)
        {
            System.out.println("root is null");
            return;
        }
        
        StringBuilder sBuilder = new StringBuilder();
        
        LinkedList<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        
        while (!levelQueue.isEmpty())
        {
            TreeNode node = levelQueue.poll();
            if (null == node)
            {
                sBuilder.append("null, ");
            }
            else
            {
                sBuilder.append(node.val);
                sBuilder.append(", ");
                
                levelQueue.add(node.left);
                levelQueue.add(node.right);
            }
        }
        
        System.out.println("root = " + sBuilder.toString());
    }
    
}
