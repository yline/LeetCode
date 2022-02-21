package com.test.search2;

import java.util.ArrayList;
import java.util.List;

import com.test.base.TreeNode;

/**
 * . 二叉树，插入，允许重复数据
 * @author YLine
 *
 * 2019年3月14日 上午11:30:01
 */
public class SolutionSearch2Insert
{
    public static final int LEFT = 0;
    
    public static final int RIGHT = 1;
    
    /**
     * .如果数据相同，则当做大的处理
     * .如果数据小于，当前节点，若无左节点，则变成子节点；若有左子节点，继续判断
     * .如果数据大于，当前节点，若无右节点，则变成子节点；若有右子节点，急需判断
     * @return 插入肯定是成功的；所以返回查询路径 + 最后选择的节点（左0，右1）
     */
    public List<Integer> insert(TreeNode<Integer> root, int data)
    {
        List<Integer> pathList = new ArrayList<>();
        dfs(root, data, pathList);
        return pathList;
    }
    
    private void dfs(TreeNode<Integer> root, int data, List<Integer> path)
    {
        if (data >= root.getData())
        {
            if (null == root.getRightNode())
            {
                path.add(root.getData());
                path.add(RIGHT);
                return;
            }
            else
            {
                path.add(root.getData());
                dfs(root.getRightNode(), data, path);
            }
        }
        else
        {
            if (null == root.getLeftNode())
            {
                path.add(root.getData());
                path.add(LEFT);
                return;
            }
            else
            {
                path.add(root.getData());
                dfs(root.getLeftNode(), data, path);
            }
        }
    }
}
