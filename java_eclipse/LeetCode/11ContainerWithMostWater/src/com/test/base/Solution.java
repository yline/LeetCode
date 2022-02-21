package com.test.base;

/**
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * 
 * @author YLine
 *
 * 2016年12月25日 下午9:04:21
 */
public interface Solution
{
    /**
     * * 额外条件:如果两边向中间移动
     * 1,左边移动,比先前地点低的,不需要移动
     * 2,右边移动,比先前地点低的,不需要移动
     * 3,左边和右边,移动较高的一边完全对于改变水容量完全没有意义
     * @param height
     * @return
     */
    public int maxArea(int[] height);
}
