package com.test;

import java.util.PriorityQueue;

import com.test.base.Solution;

public class SolutionA implements Solution{
    public int nthUglyNumber(int n) {
    	if (n == 1) {
			return 1;
		}
    	
        PriorityQueue<Long> queue = new PriorityQueue<Long>(n * 2);
        queue.add((long) 2);
        queue.add((long) 3);
        queue.add((long) 5);
        
        long last = 1;
        for (int i = 1; i < n; i++) {
			long value = queue.poll();
			
			// 重复的值
			while (last == value) {
				value = queue.poll();
			}
			
			last = value;
			queue.add(last * 2);
			queue.add(last * 3);
			queue.add(last * 5);
        }
        
        return (int)last;
    }
}
