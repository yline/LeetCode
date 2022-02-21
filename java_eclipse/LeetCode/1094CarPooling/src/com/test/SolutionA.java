package com.test;

/**
 * You are driving a vehicle that has capacity empty seats initially available for passengers.
 * The vehicle only drives east (ie. it cannot turn around and drive west.)
 * 
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip:
 * the number of passengers that must be picked up, and the locations to pick them up and drop them off.
 * The locations are given as the number of kilometers due east from your vehicle's initial location.
 * 
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 * 
 * @author YLine
 *
 * 2019年11月1日 下午12:40:30
 */
public class SolutionA
{
    public boolean carPooling(int[][] trips, int capacity)
    {
        if (null == trips || trips.length == 0)
        {
            return true;
        }
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < trips.length; i++)
        {
            min = Math.min(min, trips[i][1]);
            max = Math.max(max, trips[i][2]);
        }
        
        final int N = max - min; // 左闭右开
        int[] passengerArray = new int[N];
        
        for (int i = 0; i < trips.length; i++)
        {
            for (int j = trips[i][1]; j < trips[i][2]; j++)
            {
                passengerArray[j - min] += trips[i][0];
                if (capacity < passengerArray[j - min])
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}
