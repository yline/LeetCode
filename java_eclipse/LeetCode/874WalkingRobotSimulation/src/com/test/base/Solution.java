package com.test.base;

/**
 * A robot on an infinite[无穷大] grid starts at point (0, 0) and faces north.  
 * The robot can receive one of three possible types of commands:

-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units

Some of the grid squares are obstacles[障碍]. 

The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])

If the robot would try to move onto them, 
the robot stays on the previous grid square instead
(but still continues following the rest of the route.)

Return the square of the maximum Euclidean[欧几里得] distance that the robot will be from the origin.
返回曾今达到的，最大的，两点间真实距离；

Eulidean distance 两点间的真实距离 

Example 1:
Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)

Example 2:
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)

 * @author YLine
 *
 * 2018年12月26日 上午9:33:27
 */
public interface Solution
{
    public int robotSim(int[] commands, int[][] obstacles);
}
