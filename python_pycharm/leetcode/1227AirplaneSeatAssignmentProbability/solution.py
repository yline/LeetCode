import unittest


class Solution:
    def nthPersonGetsNthSeat(self, n: int) -> float:
        pass


class SolutionA(Solution):

    def nthPersonGetsNthSeat(self, n: int) -> float:
        if n == 1:
            return 1

        return 1/2


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
        print(solution.nthPersonGetsNthSeat(1))

        print(solution.nthPersonGetsNthSeat(2))

        print(solution.nthPersonGetsNthSeat(3))

        print(solution.nthPersonGetsNthSeat(4))
        pass


"""

n passengers board an airplane with exactly n seats. 

The first passenger has lost the ticket and picks a seat randomly. 
But after that, the rest of passengers will:

1, Take their own seat if it is still available, 
2, Pick other seats randomly when they find their seat occupied 
What is the probability that the n-th person can get his own seat?


题目：第n个人，得到他自己的位置；
假设：第i个人，对应的座位就是i; 这是一种假设也可以推广的假设

第一个随机到自己的位置，则概率为1
第一个随机到n的位置，则概率为0
第一个随机到其它[假设是2], 则可以当作是 抽取掉了一个，其他还是一样的模型，因此算作 f(n-1)   ==》 需要打通

则有公式：f(n) = 1/n + 0 + (n-2)/n*f(n-1)

边界条件：当n = 1时，f(n) = 1

则 n = 2时，f(2) = 1/2 + 0 * f(1) = 1/2

则 n = 3时，f(3) = 1/3 + 0 + 1/3*f(2) = 1/2

则 n = 4时，f(4) = 1/4 + 0 + 1/2*1/2 = 1/2






@author: yline
@time 2020/5/4 18:57
"""
