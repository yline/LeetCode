package com.test.base;

/**
 * Given an array of scores that are non-negative integers.
 * 有一个数组
 * 
 * Player 1 picks one of the numbers from either end of the array followed
 * by the player 2 and then player 1 and so on.
 * A选手，从首或者尾选一个数；然后B选，直到结束
 * 
 * Each time a player picks a number, that number will not be available for the next player.
 * This continues until all the scores have been chosen. The player with the maximum score wins.
 * 
 * 每次选择一个，到最后总和大的获胜
 * 
 * Given an array of scores, predict whether player 1 is the winner.
 * You can assume each player plays to maximize his score.
 * 
 * 给一个数组，预测A选手，能否获胜。
 * 
 * @author YLine
 *
 * 2019年5月9日 下午1:48:47
 */
public interface Solution
{
    public boolean PredictTheWinner(int[] nums);
}
