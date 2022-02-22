import unittest


class CustomFunction:
    def f(self, x: int, y: int) -> int:
        return x + y
        pass


class Solution:
    # List[List[int]]
    def findSolution(self, customfunction: CustomFunction, z: int) -> list:
        pass


class Key:
    def __init__(self, x, y) -> None:
        super().__init__()
        self.x = x
        self.y = y

    def __hash__(self) -> int:
        return self.x.__hash__() + self.y.__hash__()

    def __eq__(self, o: object) -> bool:
        if not isinstance(o, Key):
            return False

        return o.x == self.x and o.y == self.y


class SolutionA(Solution):

    def findSolution(self, customfunction: CustomFunction, z: int) -> list:
        x = 1
        y = 1
        result_list = list()

        self.dfs(set(), result_list, customfunction, x, y, z)
        return result_list

    def dfs(self, result_set: set, result_list: list, customfunction: CustomFunction, x: int, y: int, z: int):
        new_key = Key(x, y)
        if result_set.__contains__(new_key):
            return
        result_set.add(new_key)

        _value = customfunction.f(x, y)
        if _value < z:
            self.dfs(result_set, result_list, customfunction, x + 1, y, z)
            self.dfs(result_set, result_list, customfunction, x, y + 1, z)
            return

        if _value == z:
            result_list.append([x, y])


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
        result_list = solution.findSolution(CustomFunction(), 5)
        for item in result_list:
            print(item)
        pass
