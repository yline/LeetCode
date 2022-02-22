import unittest


class Solution:
    def mincostTickets(self, days: list, costs: list) -> int:
        pass


class SolutionA(Solution):

    def mincostTickets(self, days: list, costs: list) -> int:
        if days.__len__() == 1:
            return costs[0]

        # 这个缓存的空间，下标代表的是剩余天数-1，值代表的是花的钱
        cache = [-1 for i in range(30)]
        cache[0] = costs[0]
        cache[6] = costs[1]
        cache[29] = costs[2]

        temp = [-1 for i in range(30)]
        for i in range(1, days.__len__()):
            duration = days[i] - days[i - 1]

            for j in range(30):
                # 剩余天数对应的是 -1，则从来没有进入过当前位置
                if cache[j] == -1:
                    continue

                next_index = j - duration
                if next_index < 0:
                    # 剩余天数不够用，需要重置
                    old_val = cache[j]

                    if temp[0] == -1:
                        temp[0] = old_val + costs[0]
                    else:
                        temp[0] = min(temp[0], old_val + costs[0])

                    if temp[6] == -1:
                        temp[6] = old_val + costs[1]
                    else:
                        temp[6] = min(temp[6], old_val + costs[1])

                    if temp[29] == -1:
                        temp[29] = old_val + costs[2]
                    else:
                        temp[29] = min(temp[29], old_val + costs[2])
                else:
                    # 剩余天数超过需求
                    if temp[next_index] == -1:
                        temp[next_index] = cache[j]
                    else:
                        temp[next_index] = min(temp[next_index], cache[j])

            for j in range(30):
                cache[j] = temp[j]
                temp[j] = -1

        import sys

        result = sys.maxsize
        for val in cache:
            if val == -1:
                continue
            result = min(val, result)
        return result


class SolutionB(Solution):
    def mincostTickets(self, days: list, costs: list) -> int:
        n = len(days)
        opt = [0 for _ in range(days[-1] + 1)]
        for i in range(n):
            day = days[i]
            opt[day] = min(opt[day - 1] + costs[0],
                           opt[max(day - 7, 0)] + costs[1],
                           opt[max(day - 30, 0)] + costs[2])
            if i <= n - 2:
                next_day = days[i + 1]
                opt[day: next_day] = map(lambda _: opt[day], opt[day: next_day])
        opt[-1]
        return opt[-1]


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def test_solution_b(self):
        self.solution = SolutionB()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 实现具体的校验内容
        # Input: days = [1,4,6,7,8,20], costs = [2,7,15]
        # Output: 11
        days_a = [1, 4, 6, 7, 8, 20]
        costs_a = [2, 7, 15]
        self.assertEqual(11, solution.mincostTickets(days_a, costs_a))

        # Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
        # Output: 17
        days_b = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31]
        costs_b = [2, 7, 15]
        self.assertEqual(17, solution.mincostTickets(days_b, costs_b))

        days_c = [1, 3, 7]
        costs_c = [1, 4, 20]
        self.assertEqual(3, solution.mincostTickets(days_c, costs_c))
        pass


"""
In a country popular for train travel, 
you have planned some train travelling one year in advance.  

The days of the year that you will travel is given as an array days.  
Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.

The passes allow that many days of consecutive travel.  

For example, if we get a 7-day pass on day 2, 
then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to 
travel every day in the given list of days.



Example 1:
Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.

Example 2:
Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.

Note:
1 <= days.length <= 365
1 <= days[i] <= 365
days is in strictly increasing order.
costs.length == 3
1 <= costs[i] <= 1000

就是一个递推式，动态规划

@author: yline
@time 2020/3/26 19:59
"""
