package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.TreeNode;

/**
 * Given an integer n, generate all structurally
 * unique BST's (binary search trees) that store values 1 ... n.
 * 
 * 给正整数n，建立所有的唯一的搜索二叉树
 * 
 * 搜索二叉树：
 * 左 < 中 < 右
 * 
 * 典型的动态规划，只是数据太多了
 * 
 * @author YLine
 *
 * 2019年9月23日 上午9:41:06
 */
public class SolutionA
{
    public List<TreeNode> generateTrees(int n)
    {
        if (n < 1)
        {
            return new ArrayList<>();
        }
        
        // 储存，n对应的list
        List<TreeNode>[] resultArray = new ArrayList[n + 1];
        
        // 第一个内容
        List<TreeNode> tempA = new ArrayList<>();
        tempA.add(new TreeNode(1));
        resultArray[1] = tempA;
        
        // 防止，数组越界问题
        if (n == 1)
        {
            return resultArray[1];
        }
        
        // 第二个内容
        List<TreeNode> tempB = new ArrayList<>();
        tempB.add(new TreeNode(1).right = new TreeNode(2));
        tempB.add(new TreeNode(2).left = new TreeNode(1));
        resultArray[2] = tempB;
        
        // 动态规划，依次求得数组的内容
        for (int i = 2; i <= n; i++)
        {
            updateTreeByIndex(resultArray, i);
        }
        
        return resultArray[n];
    }
    
    /**
     * 更新数组内容
     * 
     * @param resultArray 已计算的内容
     * @param index 下标
     */
    private void updateTreeByIndex(List<TreeNode>[] resultArray, int index)
    {
        List<TreeNode> temp = new ArrayList<>();
        
        // 开始位置
        for (int i = 1; i <= index; i++)
        {
            if (i == 1) // 有右边，没左边
            {
                List<TreeNode> right = resultArray[index - 1];
                for (int j = 0; j < right.size(); j++)
                {
                    TreeNode top = new TreeNode(i);
                    top.right = copyAndAdd(right.get(j), 1);
                    temp.add(top);
                }
            }
            else if (i == index) // 有左边，没右边
            {
                List<TreeNode> left = resultArray[index - 1];
                for (int j = 0; j < left.size(); j++)
                {
                    TreeNode top = new TreeNode(i);
                    top.left = copyAndAdd(left.get(j), 0);
                    temp.add(top);
                }
            }
            else // 左边、右边都有
            {
                List<TreeNode> left = resultArray[i - 1]; // add = 0
                List<TreeNode> right = resultArray[index - i]; // add = i
                
                // left * right
                for (int j = 0; j < left.size(); j++)
                {
                    for (int k = 0; k < right.size(); k++)
                    {
                        TreeNode top = new TreeNode(i);
                        top.left = copyAndAdd(left.get(j), 0);
                        top.right = copyAndAdd(right.get(k), i);
                        temp.add(top);
                    }
                }
            }
        }
        
        resultArray[index] = temp;
    }
    
    /**
     * 将原来的TreeNode赋值，并添加值
     * @param node 原先
     * @param add 加法值
     * @return 新的TreeNode
     */
    private TreeNode copyAndAdd(TreeNode node, int add)
    {
        TreeNode result = new TreeNode(node.val + add);
        dfsCAA(result, node, add);
        return result;
    }
    
    private void dfsCAA(TreeNode result, TreeNode node, int add)
    {
        if (null != node.left)
        {
            if (null == node.right)
            {
                TreeNode left = new TreeNode(node.left.val + add);
                result.left = left;
                dfsCAA(result.left, node.left, add);
            }
            else
            {
                TreeNode left = new TreeNode(node.left.val + add);
                result.left = left;
                dfsCAA(result.left, node.left, add);
                
                TreeNode right = new TreeNode(node.right.val + add);
                result.right = right;
                dfsCAA(result.right, node.right, add);
            }
        }
        else
        {
            if (null != node.right)
            {
                TreeNode right = new TreeNode(node.right.val + add);
                result.right = right;
                dfsCAA(result.right, node.right, add);
            }
        }
    }
}
