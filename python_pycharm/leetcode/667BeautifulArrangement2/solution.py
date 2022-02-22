import unittest


class Solution:
    # List[int]
    def constructArray(self, n: int, k: int) -> list:
        pass


class SolutionA(Solution):

    def constructArray(self, n: int, k: int) -> list:
        """
        k = 1时；diff = 1「n」
        k = 2时；diff = 1「n-1」& n-1「1」
        k = 3时；diff = 1 & n-1 & n-2
        k = 4时；diff = 1 & n-1 & n-2 & n-3

        :param n: n个数字
        :param k: k个间隔
        :return: list
        """
        result_list = list()
        result_list.append(1)

        old_value = 1
        rest_k = k - 1
        rest_n = n - k
        flag = True

        rest_diff = n - 1
        while rest_k > 0:
            if flag:
                old_value = old_value + rest_diff
            else:
                old_value = old_value - rest_diff

            rest_diff = rest_diff - 1

            result_list.append(old_value)
            flag = not flag
            rest_k = rest_k - 1

        _diff = 1 if flag else -1
        while rest_n > 0:
            old_value = old_value + _diff
            result_list.append(old_value)
            rest_n = rest_n - 1

        return result_list


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        print(solution.constructArray(7, 1))
        print(solution.constructArray(7, 2))
        print(solution.constructArray(7, 3))
        print(solution.constructArray(7, 4))
        print(solution.constructArray(7, 5))
        print(solution.constructArray(7, 6))

        # 实现具体的校验内容
        pass


"""
Given two integers n and k, 
you need to construct a list which contains n different positive integers 
ranging from 1 to n and obeys the following requirement:

Suppose this list is [a1, a2, a3, ... , an], 
then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 
has exactly k distinct integers.

If there are multiple answers, print any of them.「其中之一」

Example 1:
Input: n = 3, k = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers 
ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.

Example 2:
Input: n = 3, k = 2
Output: [1, 3, 2]
Explanation: The [1, 3, 2] has three different positive integers 
ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.

Note:
The n and k are in the range 1 <= k < n <= 104.

案例：
k=6：1 7 2 6 3 5 | 4
k=5：1 7 2 6 3 | 4 5
k=4：1 7 2 6 | 5 4 3
k=3：1 7 2 | 3 4 5 6
k=2：1 7 | 6 5 4 3 2
k=1: 1 | 2 3 4 5 6 7

@author: yline
@time 2020/2/26 15:25
"""
