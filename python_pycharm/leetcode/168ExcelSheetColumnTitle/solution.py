"""
Given a positive integer,
return its corresponding column title as appear in an Excel sheet.

本质上来说就是一个 26进制的实现

@author: yline
@time 2020/1/3 20:38
"""

import unittest

import list_node
from list_node import ListNode


class Solution:
    def convertToTitle(self, n: int) -> str:
        pass


class SolutionA(Solution):
    def convertToTitle(self, n: int) -> str:
        if n < 1:
            return None

        source = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        length = source.__len__()

        result = ''
        while n != 0:
            index = (n - 1) % length
            n = (n - 1) // length
            result += source[index]

        # 这个是，字符串反转的意思
        return result[::-1]


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 实现具体的校验内容
        self.assertEqual('A', solution.convertToTitle(1))
        self.assertEqual('Z', solution.convertToTitle(26))
        self.assertEqual('AA', solution.convertToTitle(27))
        self.assertEqual('AB', solution.convertToTitle(28))
        pass
