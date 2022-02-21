package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 *  递推的方式，从0-2*n 依次推论，每次增加 左侧或右侧
 *  
 *  时间复杂度：
 *  n*n
 *  
 * @author YLine
 *
 * 2018年8月20日 下午2:13:57
 */
public class SolutionC implements Solution
{
    
    @Override
    public List<String> generateParenthesis(int n)
    {
        List<DataNode> result = new ArrayList<>();
        
        // 第一个需要自己手动加上
        char[] firstArray = new char[2 * n];
        firstArray[0] = '(';
        result.add(new DataNode(1, 0, firstArray));
        
        for (int i = 1; i < 2 * n; i++)
        {
            increase(result, n, i);
        }
        
        return dataNode2String(result, 2 * n);
    }
    
    private void increase(List<DataNode> result, int n, int index)
    {
        List<DataNode> increaseList = new ArrayList<>();
        for (DataNode dataNode : result)
        {
            if (dataNode.left == dataNode.right) // 如果左侧和右侧相同，只能添加左侧
            {
                dataNode.increaseLeft(index);
            }
            else if (dataNode.left == n) // 如果左侧已经满了，只能添加右侧
            {
                dataNode.increaseRight(index);
            }
            else // 左侧和右侧都需要添加
            {
                DataNode rightNode = dataNode.copy(n, index);
                rightNode.increaseLeft(index);
                increaseList.add(rightNode);
                
                dataNode.increaseRight(index);
            }
        }
        result.addAll(increaseList);
    }
    
    private static class DataNode
    {
        private int left = 0;
        
        private int right = 0;
        
        private char[] array;
        
        private DataNode(int left, int right, char[] array)
        {
            this.left = left;
            this.right = right;
            this.array = array; // 因为从未修改过历史值，因此引用和赋值并没有区别
        }
        
        private void increaseLeft(int index)
        {
            left++;
            array[index] = '(';
        }
        
        private void increaseRight(int index)
        {
            right++;
            array[index] = ')';
        }
        
        private DataNode copy(int n, int index)
        {
            char[] sArray = new char[2 * n];
            for (int i = 0; i < index; i++)
            {
                sArray[i] = array[i];
            }
            return new DataNode(left, right, sArray);
        }
        
        private String getString(int count)
        {
            return new String(array, 0, count);
        }
    }
    
    private List<String> dataNode2String(List<DataNode> data, int count)
    {
        List<String> result = new ArrayList<>();
        for (DataNode dataNode : data)
        {
            result.add(dataNode.getString(count));
        }
        return result;
    }
}
