package com.test.base;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 给一个无重叠的集合，插入一个新的集合
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 可以假设原始集合为有序的
 * 
 * @author YLine
 *
 * 2019年5月6日 上午9:16:59
 */
public interface Solution
{
    public int[][] insert(int[][] intervals, int[] newInterval);
}
