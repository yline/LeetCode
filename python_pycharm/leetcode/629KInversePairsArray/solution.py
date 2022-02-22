import unittest


class Solution:
    def kInversePairs(self, n: int, k: int) -> int:
        pass


class Key:

    def __init__(self, n, k) -> None:
        super().__init__()
        self.n = n
        self.k = k

    def __hash__(self) -> int:
        return self.n * self.k

    def __eq__(self, o: object) -> bool:
        if not isinstance(o, Key):
            return False
        return o.n == self.n and o.k == self.k


class SolutionA(Solution):

    def kInversePairs(self, n: int, k: int) -> int:
        """
        递归公式
        f(n, k) = f(n-1, k) + f(n-1, k-1) ... + f(n-1, i) 一共n个数据
        约束条件：
        1，总个数为n
        2，若k > max_dict[n-1] 则当作0
        3，i >= 0, i = k - n + 1
        :param n:
        :param k:
        :return:
        """
        if k == 0:
            return 1

        # 记录k的最大值
        max_dict = dict()
        max_dict[1] = 0
        max_dict[2] = 1
        for i in range(2, n + 1):
            max_dict[i] = max_dict[i - 1] + i - 1

        # 超越了最大值
        if k > max_dict[n]:
            return 0

        result = self.dfs(max_dict, dict(), n, k)
        print(n, k, result)
        return result

    def dfs(self, max_dict: dict, cache: dict, n, k) -> int:
        if k == 0:
            return 1
        if n == 2:
            return 1

        key = Key(n, k)
        if key in cache:
            return cache[key]

        result = 0
        left = max(0, k - n + 1)  # 左边取较大值，不越界
        right = min(k, max_dict[n - 1])  # 右边取较小值，不越界

        for k_index in range(left, right + 1):
            result = result + self.dfs(max_dict, cache, n - 1, k_index)

        cache[key] = result
        return result


class SolutionB(Solution):

    def kInversePairs(self, n: int, k: int) -> int:
        """
        和SolutionA思路一样，动态规划还是比递归要好。递归，越界了
        """
        dp = [0] * (k + 1)
        _M = 1000000007
        for i in range(1, n + 1):
            temp = [0] * (k + 1)
            temp[0] = 1
            for j in range(1, k + 1):
                val = dp[j - i] if (j - i) >= 0 else 0
                val = (dp[j] + _M - val) % _M
                temp[j] = (temp[j - 1] + val) % _M
            dp = temp

        result = dp[k - 1] if k > 0 else 0
        return (dp[k] + _M - result) % _M


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

        print(self.solution.kInversePairs(100, 100))

        pass

    def __assert_equal(self):
        solution = self.solution

        self.assertEqual(1, solution.kInversePairs(3, 0))
        self.assertEqual(2, solution.kInversePairs(3, 1))
        self.assertEqual(2, solution.kInversePairs(3, 2))
        self.assertEqual(1, solution.kInversePairs(3, 3))

        self.assertEqual(15, solution.kInversePairs(5, 3))
        self.assertEqual(22, solution.kInversePairs(5, 5))

        # 实现具体的校验内容
        pass


"""
Given two integers n and k, find how many different arrays consist of numbers from 1
 to n such that there are exactly k inverse pairs.

We define an inverse pair as following: For ith and jth element in the array, 
if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.

Since the answer may be very large, the answer should be modulo 109 + 7.

@author: yline
@time 2020/3/2 21:38
"""
