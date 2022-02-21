package com.yline.structure.demo;

import com.yline.structure.MaxHeap;
import com.yline.structure.MinHeap;

import junit.framework.TestCase;

/**
 * 对数据结构进行测试
 * @author YLine
 *
 * 2019年4月29日 下午2:45:21
 */
public class TestSample extends TestCase
{
    public void testMinHeap()
    {
        System.out.println("------------------ MinHeap --------------------");
        MinHeap<Integer> minHeap = new MinHeap<>();
        
        minHeap.add(5);
        minHeap.add(19);
        minHeap.add(12);
        minHeap.add(13);
        minHeap.add(21);
        minHeap.add(41);
        minHeap.add(16);
        minHeap.add(12);
        minHeap.add(112);
        minHeap.add(4);
        minHeap.add(200);
        
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < minHeap.getSize(); i++)
        {
            sBuilder.append((null == minHeap.getData(i) ? "null" : minHeap.getData(i)));
            sBuilder.append(" -> ");
        }
        System.out.println(sBuilder.toString());
    }
    
    public void testMaxHeap()
    {
        System.out.println("------------------ MaxHeap --------------------");
        MaxHeap<Integer> minHeap = new MaxHeap<>();
        
        minHeap.add(5);
        minHeap.add(19);
        minHeap.add(12);
        minHeap.add(13);
        minHeap.add(21);
        minHeap.add(41);
        minHeap.add(16);
        minHeap.add(12);
        minHeap.add(112);
        minHeap.add(4);
        minHeap.add(200);
        
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < minHeap.getSize(); i++)
        {
            sBuilder.append((null == minHeap.getData(i) ? "null" : minHeap.getData(i)));
            sBuilder.append(" -> ");
        }
        System.out.println(sBuilder.toString());
    }
}
