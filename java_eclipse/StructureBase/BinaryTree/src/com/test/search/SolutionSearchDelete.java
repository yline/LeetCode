package com.test.search;

import com.test.base.TreeNode;

/**
 * 二叉搜索树，删除
 * 
 * 删除后可执行的策略有：
 * 1，单纯将要删除的节点标记为“已删除”，但是并不真正从树中将这个节点去掉。
 * 这样原本删除的节点还需要存储在内存中，比较浪费内存空间，但是删除操作就变得简单了很多。
 * 而且，这种处理方法也并没有增加插入、查找操作代码实现的难度。
 * 
 * 2，(3)中，直接移动右节点不行，因为右节点可能有2个节点)
 * 1）无子节点，删除
 * 2）有单个子节点，移动过来
 * 3）有左右双子节点，需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。
 * 然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），
 * 所以，我们可以应用上面两条规则来删除这个最小节点。
 * 
 * @author YLine
 *
 * 2019年3月13日 下午11:09:23
 */
public class SolutionSearchDelete
{
    /**
     * 有相同的，则返回true，同时，实际情况，需要执行类注释策略
     * 无相同的，则返回false
     * @param rootNode
     * @param data
     * @return
     */
    public boolean delete(TreeNode<Integer> rootNode, int data)
    {
        if (null == rootNode)
        {
            return false;
        }
        
        TreeNode<Integer> temp = rootNode;
        if (data == temp.getData())
        {
            // 这里要实际要执行删除后的节点移动操作
            return true;
        }
        else if (data > temp.getData())
        {
            return delete(temp.getRightNode(), data);
        }
        else
        {
            return delete(temp.getLeftNode(), data);
        }
    }
}
