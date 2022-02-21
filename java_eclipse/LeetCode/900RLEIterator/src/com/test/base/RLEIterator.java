package com.test.base;

public abstract class RLEIterator
{
    public int index; // 当前位置
    
    public int length; // 长度
    
    public int[] data; // 数据
    
    public RLEIterator(int[] A)
    {
        index = 0;
        length = A.length >> 1 << 1;
        data = A;
    }
    
    public abstract int next(int n);
}
