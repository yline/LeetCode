package com.test.search2;

import java.util.ArrayList;
import java.util.List;

import com.test.base.TreeNode;

/**
 * 中序遍历；遍历之后的结果，应该是按递增出现
 * @author YLine
 *
 * 2019年3月14日 上午10:24:47
 */
public class SolutionSearch2OrderMiddle
{
    public List<Integer> middlerOrder(TreeNode<Integer> root)
    {
        List<Integer> result = new ArrayList<>();
        middlerOrderInner(root, result);
        return result;
    }
    
    private void middlerOrderInner(TreeNode<Integer> node, List<Integer> result)
    {
        if (null == node)
        {
            return;
        }
        
        middlerOrderInner(node.getLeftNode(), result);
        result.add(node.getData());
        middlerOrderInner(node.getRightNode(), result);
    }
}
