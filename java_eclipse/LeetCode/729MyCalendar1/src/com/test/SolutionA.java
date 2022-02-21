package com.test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Implement a MyCalendar class to store your events.
 * A new event can be added if adding the event will not cause a double booking.
 * 
 * 实现一个日程安排，用来储存你的日常安排。实现一个预定的功能，并且要求没有重叠的部分
 * 
 * Your class will have the method, book(int start, int end).
 * 类，包含一个book方法
 * Formally, this represents a booking on the half open interval [start, end),
 * the range of real numbers x such that start <= x < end.
 * 它表示，[start, end)的时间安排
 * 
 * A double booking happens when two events have some non-empty intersection
 * (ie., there is some time that is common to both events.)
 * 不允许重叠时间的预定
 * 
 * For each call to the method MyCalendar.book,
 * return true if the event can be added to the calendar successfully without causing a double booking.
 * Otherwise, return false and do not add the event to the calendar.
 * 每一次调用book方法，预定成功返回true，预定失败返回false
 * 
 * Your class will be called like this:
 * 调用案例：
 * MyCalendar cal = new MyCalendar();
 * MyCalendar.book(start, end)
 * 
 * Node: 提醒
 * The number of calls to MyCalendar.book per test case will be at most 1000. book方法，最多被调用1000次
 * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 * start 和 end 数值在 0到10^9之间
 * 
 * 思路
 * 利用Java自带的 TreeSet的红黑树排序功能，然后判断交集
 * 
 * @author YLine
 *
 * 2019年6月10日 下午2:58:01
 */
public class SolutionA
{
    private TreeSet<Event> eventSet;
    
    public SolutionA()
    {
        // 内部是红黑树
        eventSet = new TreeSet<>(new Comparator<Event>()
        {

            @Override
            public int compare(Event o1, Event o2)
            {
                return o1.start - o2.start;
            }
        });
    }
    
    public boolean book(int start, int end)
    {
        Event nowEvent = new Event(start, end);
        
        Event lowerEvent = eventSet.lower(nowEvent); // 小于给定值，但是最近的
        if (null != lowerEvent && lowerEvent.end > start)
        {
            return false;
        }
        
        Event ceilEvent = eventSet.ceiling(nowEvent); // 大于等于给定值，而且是最近的
        if (null != ceilEvent && end > ceilEvent.start) // 有交集【如果start等于,也会有交集】
        {
            return false;
        }
        
        return eventSet.add(nowEvent);
    }
    
    public static class Event
    {
        private int start; // 开始时间
        
        private int end; // 结束时间
        
        public Event(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
}
