package com.test;

public class SolutionB
{
    public static final int[] ARRAY = {5, 8, 4, 12, 32, -12, -43, 0, 9, 43, -23, 8, -4, 43, 5};
    
    /**
     * .堆排序
     */
    public int[] sortHeap()
    {
        int[] temp = ARRAY.clone();
        
        buildMaxHeap(temp);
        
        for (int i = temp.length - 1; i >= 1; i--)
        {
            exchangeElements(temp, 0, i);
            maxHeap(temp, i, 0);
        }
        
        return temp;
    }
    
    /** 创建 堆 */
    private void buildMaxHeap(int[] array)
    {
        if (array == null || array.length <= 1)
        {
            return;
        }
        
        int half = array.length / 2;
        for (int i = half; i >= 0; i--)
        {
            maxHeap(array, array.length, i);
        }
    }
    
    /** maxHeap调整堆 */
    private void maxHeap(int[] array, int heapSize, int index)
    {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        
        int largest = index;
        if (left < heapSize && array[left] > array[index])
        {
            largest = left;
        }
        
        if (right < heapSize && array[right] > array[largest])
        {
            largest = right;
        }
        
        if (index != largest)
        {
            exchangeElements(array, index, largest);
            
            maxHeap(array, heapSize, largest);
        }
    }
    
    /** 选择项,并与第0个元素交换 */
    private void exchangeElements(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
