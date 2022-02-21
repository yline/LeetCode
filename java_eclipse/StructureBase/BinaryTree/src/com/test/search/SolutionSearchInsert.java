package com.test.search;

import com.test.base.TreeNode;

/**
 * 二叉树，插入
 * @author YLine
 *
 * 2019年3月13日 下午6:21:21
 */
public class SolutionSearchInsert
{
    /**
     * 大的插入右方，小的插入左方，所以返回插入的节点即可
     * 如果存在相同的value，则返回失败
     */
    public boolean insert(TreeNode<Integer> root, int data)
    {
        TreeNode<Integer> temp = root;
        if (data == temp.getData())
        {
            return false;
        }
        else if (data > temp.getData())
        {
            if (null != temp.getRightNode())
            {
                return insert(temp.getRightNode(), data);
            }
            else
            {
                // 这里代表插入右节点
                System.out.println("insert right, parent = " + temp.getData());
                return true;
            }
        }
        else
        {
            if (null != temp.getLeftNode())
            {
                return insert(temp.getLeftNode(), data);
            }
            else
            {
                // 这里代表插入左节点
                System.out.println("insert left, parent = " + temp.getData());
                return true;
            }
            
        }
    }
}
