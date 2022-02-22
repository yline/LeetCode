import unittest

import list_node
from list_node import ListNode


class Solution:
    # fronts: List[int], backs: List[int]
    def flipgame(self, fronts: list, backs: list) -> int:
        pass

    pass


class SolutionB(Solution):

    def flipgame(self, fronts: list, backs: list) -> int:
        _same = set()
        for index in range(fronts.__len__()):
            if fronts[index] == backs[index]:
                _same.add(fronts[index])

        # 找出最小值
        ans = 9999
        for _value in fronts:
            if not _same.__contains__(_value):
                ans = min(ans, _value)

        for _value in backs:
            if not _same.__contains__(_value):
                ans = min(ans, _value)

        return ans % 9999


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_b(self):
        self.solution = SolutionB()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        fronts_a = [1, 2, 4, 4, 7]
        backs_a = [1, 3, 4, 1, 3]
        self.assertEqual(2, solution.flipgame(fronts_a, backs_a))

        fronts_b = [1, 1]
        backs_b = [1, 2]
        self.assertEqual(2, solution.flipgame(fronts_b, backs_b))

        # 实现具体的校验内容
        pass


"""
1 <= fronts.length == backs.length <= 1000.
1 <= fronts[i] <= 2000.
1 <= backs[i] <= 2000.

@author: yline
@time 2020/2/5 16:03
"""
