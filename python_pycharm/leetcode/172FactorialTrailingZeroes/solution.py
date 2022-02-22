import unittest

import list_node
from list_node import ListNode


class Solution:
    def trailingZeroes(self, n: int) -> int:

        pass


class SolutionA(Solution):
    def trailingZeroes(self, n: int) -> int:
        """
        f(x) = ? + f(x-5); x为5的倍数
        ? 为能整除以5的次数
        :param n: 最终的数据
        :return: 尾数为0的个数
        """
        result = 0
        index = 5
        while index <= n:
            result += self.get_count_by_5(index)
            index += 5
        return result

    pass

    def get_count_by_5(self, pos: int):
        result = 0
        while pos % 5 == 0:
            pos //= 5
            result += 1
        return result


class SolutionB(Solution):
    def trailingZeroes(self, n: int) -> int:
        """
        f(n) = 5的个数 + 25的个数 + 625的个数 + ...
        :param n:
        :return:
        """
        po = 1
        fives = 0
        while n // (5 ** po) > 0:
            fives = fives + n // (5 ** po)
            po = po + 1
        return fives


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
        self.assertEqual(0, solution.trailingZeroes(3))
        self.assertEqual(1, solution.trailingZeroes(5))
        self.assertEqual(6, solution.trailingZeroes(25))
        self.assertEqual(4, solution.trailingZeroes(20))
        pass


"""
Given an integer n, return the number of trailing zeroes in n!.

Example 1:
Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:
Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.

@author: yline
@time 2020/1/9 19:32
"""
