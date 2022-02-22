import unittest


class Solution:
    def canReach(self, arr: list, start: int) -> bool:
        pass


class SolutionA(Solution):
    def canReach(self, arr: list, start: int) -> bool:
        visited_array = [False] * len(arr)
        return self.dfs_search(arr, visited_array, start)

    def dfs_search(self, aar: list, visited: list, index: int) -> bool:
        # 入口校验
        if index < 0 or index >= len(aar):
            return False

        # 访问数据
        if visited[index]:
            return False
        visited[index] = True

        if aar[index] == 0:
            return True

        left_index = index - aar[index]
        right_index = index + aar[index]
        return self.dfs_search(aar, visited, left_index) \
               or self.dfs_search(aar, visited, right_index)


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        self.assertEqual(True, solution.canReach([4, 2, 3, 0, 3, 1, 2], 5))
        self.assertEqual(True, solution.canReach([4, 2, 3, 0, 3, 1, 2], 0))
        self.assertEqual(False, solution.canReach([3, 0, 2, 1, 2], 2))
        # 实现具体的校验内容
        pass
