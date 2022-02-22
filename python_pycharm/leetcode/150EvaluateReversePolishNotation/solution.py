import unittest


class Solution:
    # List[str]
    def evalRPN(self, tokens: list) -> int:
        pass

    pass


class SolutionA(Solution):

    def evalRPN(self, tokens: list) -> int:
        from queue import LifoQueue

        _queue = LifoQueue()

        for _val in tokens:
            if '+' == _val:
                second_val = _queue.get()
                first_val = _queue.get()
                _queue.put(first_val + second_val)
            elif '-' == _val:
                second_val = _queue.get()
                first_val = _queue.get()
                _queue.put(first_val - second_val)
            elif '*' == _val:
                second_val = _queue.get()
                first_val = _queue.get()
                _queue.put(first_val * second_val)
            elif '/' == _val:
                second_val = _queue.get()
                first_val = _queue.get()

                new_val = int(first_val / second_val)
                _queue.put(new_val)
            else:
                int_val = self.str_2_int(_val)
                _queue.put(int_val)

        if _queue.empty():
            return 0
        return _queue.get()

    def str_2_int(self, _str: str) -> int:
        try:
            return int(_str)
        except Exception as ex:
            print(ex)
            return 0


class SolutionB(Solution):

    def evalRPN(self, tokens: list) -> int:
        # The given RPN expression is always valid.
        # non-empty s

        # keep a stack of unused numbers
        # push and pop
        nums = []
        for t in tokens:
            if t not in {'+', '-', '*', '/'}:
                nums.append(int(t))
            else:
                last = nums.pop()
                if t == '+':
                    nums[-1] += last
                elif t == '-':
                    nums[-1] -= last
                elif t == '*':
                    nums[-1] *= last
                elif t == '/':
                    nums[-1] = int(nums[-1] / last)  # trancated to 0

        return nums[0]


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
        self.assertEqual(9, solution.evalRPN(["2", "1", "+", "3", "*"]))
        self.assertEqual(6, solution.evalRPN(["4", "13", "5", "/", "+"]))
        self.assertEqual(22, solution.evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]))
        pass


"""
Evaluate「计算」 the value of an arithmetic「算数」 expression 
in Reverse Polish「波兰」 Notation「符号」.

Valid operators are +, -, *, /. 
Each operand may be an integer or another expression.

Note:
Division between two integers should truncate「截断」 toward zero.
The given RPN expression is always valid. 
That means the expression would always evaluate to a result 
and there won't be any divide by zero operation.

Example 1:
Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

@author: yline
@time 2020/2/19 18:38
"""
