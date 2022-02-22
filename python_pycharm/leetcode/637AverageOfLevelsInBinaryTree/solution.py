import unittest

import tree_node
from tree_node import TreeNode


class Solution:
    # List[float]
    def averageOfLevels(self, root: TreeNode) -> list:
        pass


class LevelValue:

    def __init__(self, value) -> None:
        self.count = 1
        self.total = value

    def add_value(self, value):
        self.count += 1
        self.total += value


class SolutionA(Solution):

    def averageOfLevels(self, root: TreeNode) -> list:
        _result = list()

        if root is None:
            return _result

        _result_cache = list()
        self.dfs(root, 0, _result_cache)

        for item in _result_cache:
            _result.append(item.total / item.count)

        return _result

    def dfs(self, node: TreeNode, level: int, data_list: list):
        if node is None:
            return

        if level == data_list.__len__():
            data_list.append(LevelValue(node.val))
        else:
            data_list[level].add_value(node.val)

        self.dfs(node.left, level + 1, data_list)
        self.dfs(node.right, level + 1, data_list)


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        root_a = tree_node.build(2, 9, 20, None, None, 15, 7)
        result_a = solution.averageOfLevels(root_a)
        print(result_a)

        # 实现具体的校验内容
        pass
