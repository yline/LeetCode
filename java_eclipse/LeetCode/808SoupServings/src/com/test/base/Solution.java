package com.test.base;

/**
 * There are two types of soup: type A and type B.
 * Initially we have N ml of each type of soup. There are four kinds of operations:
 * 
 * 有两类汤，每一个开始有N ml,有如下四种分配方案：
 * Serve 100 ml of soup A and 0 ml of soup B
 * Serve 75 ml of soup A and 25 ml of soup B
 * Serve 50 ml of soup A and 50 ml of soup B
 * Serve 25 ml of soup A and 75 ml of soup B
 * 
 * When we serve some soup, we give it to someone and we no longer have it.
 * Each turn, we will choose from the four operations with equal probability 0.25.
 * If the remaining volume of soup is not enough to complete the operation,
 * we will serve as much as we can.
 * We stop once we no longer have some quantity of both types of soup.
 * 
 * 每一种方案，有25%的概率，一旦某种方案不能满足，则代表停止
 * 
 * Note that we do not have the operation where all 100 ml's of soup B are used first.
 * 
 * Return the probability that soup A will be empty first,
 * plus half the probability that A and B become empty at the same time.
 * 
 * 返回A先不满足的概率 + AB同时不满足概率的1/2；的和
 * 
 * @author YLine
 *
 * 2019年5月9日 上午8:23:03
 */
public interface Solution
{
    public double soupServings(int N);
}
