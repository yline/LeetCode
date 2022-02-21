package com.test.search;

import com.test.base.TreeNode;

/**
 * 二叉查找树，查找操作
 * @author YLine
 *
 * 2019年3月12日 下午6:12:25
 */
public class SolutionSearchLookup
{
    /**
     * @param data 数值
     * @return 对应的节点，null if 不存在
     */
    public TreeNode<Integer> find(TreeNode<Integer> root, int data)
    {
        if (null == root)
        {
            return null;
        }
        
        TreeNode<Integer> temp = root;
        if (data == temp.getData())
        {
            return temp;
        }
        else if (data < temp.getData())
        {
            return find(temp.getLeftNode(), data);
        }
        else
        {
            return find(temp.getRightNode(), data);
        }
    }
}
