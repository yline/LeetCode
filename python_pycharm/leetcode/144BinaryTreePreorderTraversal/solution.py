"""
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

@author: yline
@time 2020/1/8 23:59
"""

import unittest

from tree_node import TreeNode


class Solution:
    def preorderTraversal(self, root: TreeNode) -> list:
        pass


class SolutionA(Solution):
    def preorderTraversal(self, root: TreeNode) -> list:
        result = list()
        pre_dfs(root, result)
        return result


def pre_dfs(node: TreeNode, result: list):
    if node is None:
        return
    result.append(node.val)
    pre_dfs(node.left, result)
    pre_dfs(node.right, result)


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
        pass
