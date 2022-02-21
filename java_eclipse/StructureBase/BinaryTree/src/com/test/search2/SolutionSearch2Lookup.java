package com.test.search2;

import com.test.base.TreeNode;

/**
 * 二叉查找树，查找操作[有重复数据]
 * @author YLine
 *
 * 2019年3月14日 上午10:42:34
 */
public class SolutionSearch2Lookup
{
    /**
     * 
     * @param data 数值
     * @return 符合的个数，0 if 不存在
     */
    public int find(TreeNode<Integer> root, int data)
    {
        return dfs(root, data);
    }
    
    public int dfs(TreeNode<Integer> root, int data)
    {
        if (null == root)
        {
            return 0;
        }
        
        if (data == root.getData())
        {
            // 这里是满足条件的
            return 1 + dfs(root.getRightNode(), data);
        }
        else if (data > root.getData())
        {
            return dfs(root.getRightNode(), data);
        }
        else
        {
            return dfs(root.getLeftNode(), data);
        }
    }
}
