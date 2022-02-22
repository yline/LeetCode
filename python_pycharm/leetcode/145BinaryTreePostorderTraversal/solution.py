import unittest

import list_node
import tree_node
from list_node import ListNode
from tree_node import TreeNode


class Solution:
    def postorderTraversal(self, root: TreeNode) -> list:
        pass
    pass


class SolutionA(Solution):
    def postorderTraversal(self, root: TreeNode) -> list:
        result = list()
        self.post_dfs(result, root)
        return result

    def post_dfs(self, result: list, node: TreeNode):
        if node is None:
            return
        self.post_dfs(result, node.left)
        self.post_dfs(result, node.right)
        result.append(node.val)


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        root_a = tree_node.build(1, None, 2, None, None, 3)
        tree_node.print_tree(root_a)

        # 实现具体的校验内容
        pass


"""
Given a binary tree, 
return the postorder traversal of its nodes' values.
// 后续排序

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

@author: yline
@time 2020/1/18 10:45
"""
