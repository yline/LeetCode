"""
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty
and the majority element always exist in the array.

思路：遇到不同的数值，消除即可

@author: yline
@time 2020/1/7 19:33
"""

import unittest

import list_node
from list_node import ListNode


class Solution:
    def majorityElement(self, nums: list) -> int:
        pass


class SolutionA(Solution):
    def majorityElement(self, nums: list) -> int:
        result = None
        size = 0
        for val in nums:
            if size == 0:
                result = val
                size += 1
            elif result == val:
                size += 1
            else:
                size -= 1
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
        self.assertEqual(3, solution.majorityElement([3, 2, 3]))
        self.assertEqual(2, solution.majorityElement([2, 2, 1, 1, 1, 2, 2]))
        pass
