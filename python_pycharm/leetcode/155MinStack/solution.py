"""
Design a stack that supports push, pop, top,
and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example:
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.

@author: yline
@time 2019/12/30 08:38
"""
import unittest

import sys


class Solution:
    """
    定义抽象类
    """
    def __init__(self):
        """
        initialize your data structure here.
        """

    def push(self, x: int) -> None:
        pass

    def pop(self) -> None:
        pass

    def top(self) -> int:
        pass

    def getMin(self) -> int:
        pass


class SolutionA(Solution):
    data_list = list()

    def __init__(self):
        """
        initialize your data structure here.
        """
        super().__init__()
        global data_list
        data_list = list()

    def push(self, x: int) -> None:
        global data_list
        data_list.append(x)
        pass

    def pop(self) -> None:
        global data_list
        data_list.pop(-1)
        pass

    def top(self) -> int:
        global data_list
        return data_list[-1]

    def getMin(self) -> int:
        global data_list
        return min(data_list)


class SolutionB(Solution):
    """
    思路：用空间换时间，每次有新的内容加入；则，同时记录上一个最小值
    """
    def __init__(self):
        """
        initialize your data structure here.
        """
        super().__init__()
        self.data = []
        self.min = sys.maxsize

    def push(self, x: int) -> None:
        if x <= self.min:
            self.data.append(self.min)
            self.min = x
            self.data.append(x)
        else:
            self.data.append(x)

    def pop(self) -> None:
        if self.data[-1] == self.min:
            self.data.pop()
            self.min = self.data[-1]
        self.data.pop()

    def top(self) -> int:
        return self.data[-1]

    def getMin(self) -> int:
        return self.min


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
        min_stack = self.solution

        # 实现具体的校验内容
        min_stack.push(-2)
        min_stack.push(0)
        min_stack.push(-3)
        self.assertEqual(-3, min_stack.getMin())

        min_stack.pop()
        self.assertEqual(0, min_stack.top())
        self.assertEqual(-2, min_stack.getMin())
        pass
