package com.test;

import com.test.greedy.CoinChange;

import junit.framework.TestCase;

public class GreedySample extends TestCase
{
    public void testCoinChange()
    {
        CoinChange change = new CoinChange();
        assertEquals(-1, change.minPaper(-1));
        assertEquals(0, change.minPaper(0));
        assertEquals(1, change.minPaper(1));
        assertEquals(1, change.minPaper(2));
        assertEquals(2, change.minPaper(3));
        assertEquals(2, change.minPaper(6));
        assertEquals(2, change.minPaper(7));
        assertEquals(3, change.minPaper(8));
        assertEquals(3, change.minPaper(9));
        assertEquals(3, change.minPaper(13));
        assertEquals(4, change.minPaper(33));
        assertEquals(3, change.minPaper(53));
        assertEquals(4, change.minPaper(63));
        assertEquals(4, change.minPaper(73));
        assertEquals(5, change.minPaper(223));
    }
}
