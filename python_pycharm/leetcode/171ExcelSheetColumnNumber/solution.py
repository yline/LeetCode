
import unittest

import list_node
from list_node import ListNode


class Solution:
    def titleToNumber(self, s: str) -> int:
        pass
    pass


class SolutionA(Solution):
    def titleToNumber(self, s: str) -> int:
        result = 0

        multi = 1
        start = ord('A')

        length = s.__len__() - 1
        while length >= 0:
            result += multi * (ord(s[length]) - start + 1)
            length -= 1
            multi *= 26
        return result
    pass


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
        self.assertEqual(1, solution.titleToNumber('A'))
        self.assertEqual(28, solution.titleToNumber('AB'))
        self.assertEqual(701, solution.titleToNumber('ZY'))
        pass
