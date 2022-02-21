package com.test.base;

/**
 * We have a list of bus routes.
 * Each routes[i] is a bus route that the i-th bus repeats forever.
 * 
 * For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed)
 * travels in the sequence 1->5->7->1->5->7->1->... forever.
 * 
 * We start at bus stop S (initially not on a bus),
 * and we want to go to bus stop T. Travelling by buses only,
 * what is the least number of buses we must take to reach our destination?
 * Return -1 if it is not possible.
 * 
 * Example:
 * Input:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * Output: 2
 * 
 * @author YLine
 *
 * 2019年10月15日 下午9:11:53
 */
public interface Solution
{
    public int numBusesToDestination(int[][] routes, int S, int T);
}
