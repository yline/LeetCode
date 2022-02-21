package com.yline.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 小顶堆，数据结构
 * 
 * 特点：
 * 1，完全二叉树
 * 2，每一个节点的值，都必须小于等于其子树中每个节点的值
 * 
 * @author YLine
 *
 * 2019年4月29日 上午9:59:52
 */
public class MaxHeap<T extends Comparable<T>>
{
    private List<T> mDataList;
    
    public MaxHeap()
    {
        mDataList = new ArrayList<>();
        mDataList.add(null); // 首个空
    }
    
    public void add(T t)
    {
        // 插入最后一个
        mDataList.add(t);
        
        // 从下至上，堆化
        HeapUtils.heapifyUp(mDataList, mDataList.size() - 1, false);
    }
    
    public T poll()
    {
        if (mDataList.size() == 1)
        {
            return null;
        }
        
        if (mDataList.size() == 2)
        {
            T value = mDataList.get(1);
            mDataList.remove(1);
            return value;
        }
        
        // 首个和最后一个互换
        T firstValue = mDataList.get(1);
        
        T lastValue = mDataList.get(mDataList.size() - 1);
        mDataList.remove(mDataList.size() - 1);
        mDataList.set(1, lastValue);
        
        // 从上至下堆化
        HeapUtils.heapifyDown(mDataList, 1, mDataList.size() - 1, false);

        return firstValue;
    }
    
    public T peek()
    {
        if (mDataList.size() == 1)
        {
            return null;
        }
        return mDataList.get(1);
    }
    
    public int getSize()
    {
        return mDataList.size();
    }
    
    public T getData(int index)
    {
        return mDataList.get(index);
    }
    
    public boolean isEmpty()
    {
        return mDataList.size() == 1;
    }
    
    /**
     * 更新最后一个
     * @param t
     */
    public void updateLast(T t)
    {
        // 更新最后一个数据
        mDataList.set(mDataList.size() - 1, t);
        
        // 从下至上堆化
        HeapUtils.heapifyUp(mDataList, mDataList.size() - 1, false);
    }
}
