package com.test.search2;

import com.test.base.TreeNode;

/**
 * 二叉搜索树，删除【有重复数据】
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
 * 2019年3月14日 下午2:00:46
 */
public class SolutionSearch2Delete
{
    /**
     * .返回可以删除的元素的个数；若无，则返回0
     * @return 0 if not exist
     */
    public int delete(TreeNode<Integer> root, int data)
    {
        return deleteInner(root, data);
    }
    
    private int deleteInner(TreeNode<Integer> root, int data)
    {
        if (null == root)
        {
            return 0;
        }
        
        if (data == root.getData())
        {
            return 1 + deleteInner(root.getRightNode(), data);
        }
        else if (data > root.getData())
        {
            return deleteInner(root.getRightNode(), data);
        }
        else
        {
            return deleteInner(root.getLeftNode(), data);
        }
    }
}
