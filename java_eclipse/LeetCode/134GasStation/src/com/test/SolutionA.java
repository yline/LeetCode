package com.test;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and
 * it costs cost[i] of gas to travel from station i to its next station (i+1).
 * 
 * You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index
 * if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * 
 * note:
 * If there exists a solution, it is guaranteed to be unique. // 若有解，则唯一
 * Both input arrays are non-empty and have the same length. // 长度相同，非空
 * Each element in the input arrays is a non-negative integer. // 无负数
 * 
 * 方案1：直接遍历，一旦有结果则返回
 * 
 * 方案2：利用若有解，则唯一的条件
 * 
 * @author YLine
 *
 * 2019年12月9日 上午9:42:59
 */
public class SolutionA
{
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        // 入口先抛出，条件不符合的
        if (null == gas || null == cost || gas.length == 0 || gas.length != cost.length)
        {
            return -1;
        }
        
        int prev = -1; // it stores which should be our first gas station
        int cur = 0;
        for (int i = 0; i < gas.length; i++)
        {
            cur += (gas[i] - cost[i]);
            if (cur < 0) // the moment we run out of gas we reset our first gas station
            {
                cur = 0;
                prev = -1;
            }
            else if (prev == -1)
            { // we found new "first" gas station
                prev = i;
            }
        }
        
        // 全部不符合
        if (cur < 0)
        {
            return -1;
        }
        
        // now we complete the circle
        for (int i = 0; i < prev; i++)
        {
            cur += (gas[i] - cost[i]);
        }
        
        // if we reach our first gas station with negative fuel means we dint reach actually
        if (cur < 0)
        {
            return -1;
        }
        
        // else we reached first gas station
        return prev;
    }
    
}
